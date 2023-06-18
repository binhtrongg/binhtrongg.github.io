package com.example.mvctest.controller;
import com.example.mvctest.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class EmailSendingController {
    EmailService emailService;

    @PostMapping("/{email}/otp-sending")
    public void sendOtp(@PathVariable String email, @RequestBody String isApproved) {
        emailService.sendSimpleMail(email,isApproved);
    }

    @PostMapping("/{email}/sent-notification")
    public void sendNofication(@PathVariable String email){
        emailService.sendNotification(email);
    }
}
