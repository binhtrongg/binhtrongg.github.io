package com.example.chonqjetairwebapp.service;

import com.example.chonqjetairwebapp.entity.Role;
import com.example.chonqjetairwebapp.entity.User;
import com.example.chonqjetairwebapp.exception.ActivatedAccountException;
import com.example.chonqjetairwebapp.exception.ExistedUserException;
import com.example.chonqjetairwebapp.exception.RefreshTokenNotFoundException;
import com.example.chonqjetairwebapp.model.request.CreateUserRequest;
import com.example.chonqjetairwebapp.model.request.RefreshTokenRequest;
import com.example.chonqjetairwebapp.model.request.RegistrationRequest;
import com.example.chonqjetairwebapp.model.request.ResetPasswordRequest;
import com.example.chonqjetairwebapp.model.response.JwtResponse;
import com.example.chonqjetairwebapp.model.response.UserResponse;
import com.example.chonqjetairwebapp.repository.RefreshTokenRepository;
import com.example.chonqjetairwebapp.repository.RoleRepository;
import com.example.chonqjetairwebapp.repository.UserRepository;
import com.example.chonqjetairwebapp.security.CustomUserDetails;
import com.example.chonqjetairwebapp.security.JwtUtils;
import com.example.chonqjetairwebapp.security.SecurityUtils;
import com.example.chonqjetairwebapp.statics.Roles;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserService {

    final PasswordEncoder passwordEncoder;

    final UserRepository userRepository;

    final RoleRepository roleRepository;

    final ObjectMapper objectMapper;

    final RefreshTokenRepository refreshTokenRepository;

    final EmailService emailService;

    @Value("${application.security.refreshToken.tokenValidityMilliseconds}")
    long refreshTokenValidityMilliseconds;

    final JwtUtils jwtUtils;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository,
                       RoleRepository roleRepository, ObjectMapper objectMapper,
                       RefreshTokenRepository refreshTokenRepository, JwtUtils jwtUtils,EmailService emailService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.objectMapper = objectMapper;
        this.refreshTokenRepository = refreshTokenRepository;
        this.jwtUtils = jwtUtils;
        this.emailService=emailService;
    }

    public void registerUser(RegistrationRequest registrationRequest) {
        Optional<Role> optionalRole = roleRepository.findByName(Roles.USER);
        Set<Role> roles = new HashSet<>();
        roles.add(optionalRole.get());
        User user = User.builder()
                .email(registrationRequest.getEmail())
                .password(passwordEncoder.encode(registrationRequest.getPassword()))
                .roles(roles)
                .build();
        userRepository.save(user);
        emailService.sendActivationEmail(registrationRequest.getEmail(), user.getId());
    }


    public List<UserResponse> getAll() {
        List<User> users = userRepository.findAll();
        if (!CollectionUtils.isEmpty(users)) {
            return users.stream().map(u -> objectMapper.convertValue(u, UserResponse.class)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public UserResponse getDetail(Long id) throws ClassNotFoundException {
        return userRepository.findById(id).map(u -> objectMapper.convertValue(u, UserResponse.class)).orElseThrow(ClassNotFoundException::new);
    }

    public JwtResponse refreshToken(RefreshTokenRequest request) throws RefreshTokenNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        String newToken = userRepository.findById(userDetails.getId())
                .flatMap(user -> refreshTokenRepository.findByUserAndRefreshTokenAndInvalidated(user, request.getRefreshToken(), false)
                        .map(refreshToken -> {
                            LocalDateTime createdDateTime = refreshToken.getCreatedDateTime();
                            LocalDateTime expiryTime = createdDateTime.plusSeconds(refreshTokenValidityMilliseconds / 1000);
                            if (expiryTime.isBefore(LocalDateTime.now())) {
                                refreshToken.setInvalidated(true);
                                refreshTokenRepository.save(refreshToken);
                                return null;
                            }
                            return jwtUtils.generateJwtToken(authentication);
                        }))
                .orElseThrow(() -> new UsernameNotFoundException("Tài khoản không tồn tại"));


        if (newToken == null) {
            throw new RefreshTokenNotFoundException();
        }
        return JwtResponse.builder()
                .jwt(newToken)
                .build();
    }

    @Transactional
    public void logout() {
        Optional<Long> userIdOptional = SecurityUtils.getCurrentUserLoginId();
        if (userIdOptional.isEmpty()) {
            throw new UsernameNotFoundException("Tài khoản không tồn tại");
        }
        refreshTokenRepository.logOut(userIdOptional.get());
        SecurityContextHolder.clearContext();
    }

    public void createUser(CreateUserRequest request) throws ExistedUserException {
        Optional<User> userOptional = userRepository.findByEmail(request.getEmail());
        if (!userOptional.isEmpty()) {
            throw new ExistedUserException();
        }

        Set<Role> roles = roleRepository.findByName(Roles.USER).stream().collect(Collectors.toSet());

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode("123"))
                .roles(roles)
                .build();
        userRepository.save(user);
    }

    public Boolean existUserByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public void sendOtp(String email) throws ExistedUserException {
        if (!userRepository.existsByEmail(email)){
            throw new ExistedUserException();
        }
        else {
            emailService.sendSimpleMail(email);
        }
    }

    public void reserPassword(ResetPasswordRequest request) {
        Optional<User> userOptional=userRepository.findByEmail(request.getEmail());
        if (userOptional.isPresent()){
            User user=userOptional.get();
            user.setPassword(passwordEncoder.encode(request.getNewPassword()));
            userRepository.save(user);
        }
    }

    public void activeAccount(Long id) throws ActivatedAccountException {
        Optional<User> userOptional=userRepository.findById(id);
        if (userOptional.isPresent()){
            User user=userOptional.get();
            if (!user.isActivated()){
                user.setActivated(true);
                userRepository.save(user);
            }
            else {
                throw new ActivatedAccountException("Tài Khoản Đã Được Kích Hoạt RỒi");
            }
        }
    }

    public void resentActivationEmail(String email) {
        Optional<User> userOp = userRepository.findByEmail(email);
        User user = userOp.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        emailService.sendActivationEmail(email, user.getId());
    }
}
