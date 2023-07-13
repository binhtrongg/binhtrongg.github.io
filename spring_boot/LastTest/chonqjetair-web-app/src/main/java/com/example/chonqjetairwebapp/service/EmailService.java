package com.example.chonqjetairwebapp.service;
import com.example.chonqjetairwebapp.entity.Otp;
import com.example.chonqjetairwebapp.entity.User;
import com.example.chonqjetairwebapp.repository.OtpRepository;
import com.example.chonqjetairwebapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;


    OtpService otpService;

    UserRepository userRepository;

    OtpRepository otpRepository;

    @Value("${spring.mail.username}")
    private String sender;

    public EmailService(JavaMailSender javaMailSender, OtpService otpService, UserRepository userRepository,OtpRepository otpRepository) {
        this.otpService=otpService;
        this.javaMailSender = javaMailSender;
        this.userRepository =userRepository;
        this.otpRepository=otpRepository;
    }

    public void sendSimpleMail(String receiver) {
        // Creating a simple mail message
        SimpleMailMessage mailMessage = new SimpleMailMessage();


        Optional<User> userOptional =userRepository.findByEmail(receiver);
        if (userOptional.isPresent()){
            User user=userOptional.get();
            Otp otp=Otp.builder()
                    .otpCode(otpService.generateOTP())
                    .creatTime(LocalDateTime.now())
                    .expiredTime(LocalDateTime.now().plus(30, ChronoUnit.MINUTES))
                    .user(user)
                    .build();
            otpRepository.save(otp);
            mailMessage.setFrom(sender);
            mailMessage.setTo(receiver);
            mailMessage.setText("Mã OTP của bạn là:"+otp.getOtpCode()+". Không chia sẻ mã này cho bất kỳ ai!");
            mailMessage.setSubject("[SkyHub] OTP Vefification");

            // Sending the mail
            javaMailSender.send(mailMessage);
        }

        // Setting up necessary details
    }
}
