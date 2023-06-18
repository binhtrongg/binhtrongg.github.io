package com.example.mvctest.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendSimpleMail(String receiver, String isApproved) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(sender);
        mailMessage.setTo(receiver);

        if (isApproved.equals("true")) {
            mailMessage.setText("Yêu cầu đã được phê duyệt,cảm ơn bạn đã sử dụng dịch vụ");
            mailMessage.setSubject("Phê duyệt yêu cầu");
        } else {
            mailMessage.setText("Yêu cầu đã bị từ chối,đen");
            mailMessage.setSubject("Từ chối yêu cầu");
        }

        javaMailSender.send(mailMessage);
    }

    public void sendNotification(String email) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(sender);
        mailMessage.setTo(email);
        mailMessage.setText("Vui Lòng Nạp Tiền");
        mailMessage.setSubject("Sắp Mua Được Hàng");
        javaMailSender.send(mailMessage);
    }
}
