package com.example.chonqjetairwebapp.config;
import com.example.chonqjetairwebapp.entity.Role;
import com.example.chonqjetairwebapp.entity.User;
import com.example.chonqjetairwebapp.repository.RoleRepository;
import com.example.chonqjetairwebapp.repository.UserRepository;
import com.example.chonqjetairwebapp.statics.Roles;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DatabaseInitializer implements CommandLineRunner {

    UserRepository userRepository;

    RoleRepository roleRepository;

    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Optional<Role> roleOptional=roleRepository.findByName(Roles.USER);
        if (roleOptional.isEmpty()){
            Role userRole = Role.builder().name(Roles.USER).build();
            roleRepository.save(userRole);
        }
        Optional<Role> roleOptional1=roleRepository.findByName(Roles.ADMIN);
        if (roleOptional1.isEmpty()){
            Role adminRole = Role.builder().name(Roles.ADMIN).build();
            roleRepository.save(adminRole);
            Optional<User> userOptional=userRepository.findByEmail("admin@gmail.com");
            if (userOptional.isEmpty()){
                User user = new User();
                user.setEmail("admin@gmail.com");
                user.setPassword(passwordEncoder.encode("admin123")); // Encrypt the password
                Set<Role> roles = new HashSet<>();
                roles.add(adminRole);
                user.setRoles(roles);
                userRepository.save(user);
            }
        }
//
//        Role adminRole = Role.builder().name(Roles.ADMIN).build();
//        roleRepository.save(adminRole);

    }

}
