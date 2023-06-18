package com.example.mvctest.controller;
import com.example.mvctest.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class EmailSendingController {
    EmailService emailService;

    @PostMapping("/{email}/otp-sending")
    public void sendOtp(@PathVariable String email) {
        emailService.sendSimpleMail(email);
    }
}
