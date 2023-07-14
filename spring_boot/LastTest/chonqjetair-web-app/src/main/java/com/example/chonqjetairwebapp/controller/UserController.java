package com.example.chonqjetairwebapp.controller;
import com.example.chonqjetairwebapp.exception.ExistedUserException;
import com.example.chonqjetairwebapp.model.request.CreateUserRequest;
import com.example.chonqjetairwebapp.model.request.ExistedEmailRequest;
import com.example.chonqjetairwebapp.model.request.ResetPasswordRequest;
import com.example.chonqjetairwebapp.model.response.UserResponse;
import com.example.chonqjetairwebapp.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserService userService;

    @GetMapping
    public List<UserResponse> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserResponse getDetail(@PathVariable Long id) throws ClassNotFoundException {
        return userService.getDetail(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreateUserRequest request) {
        try {
            userService.createUser(request);
            return ResponseEntity.ok(null);
        } catch (ExistedUserException ex) {
            return new ResponseEntity<>("email đã tồn tại", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/email-check")
    public ResponseEntity<Boolean> existByEmail(@RequestBody ExistedEmailRequest existedEmailRequest){
        return ResponseEntity.ok(userService.existUserByEmail(existedEmailRequest.getEmail()));
    }

    @PostMapping("/{email}/otp-sending")
    public void sendOtp(@PathVariable String email) {
        userService.sendOtp(email);
    }

    @PutMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest request){
        userService.reserPassword(request);
        return ResponseEntity.ok(null);
    }

}
