package com.example.chonqjetairwebapp.repository;

import com.example.chonqjetairwebapp.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OtpRepository extends JpaRepository<Otp,Long> {
    Optional<Otp> findByOtpCode (String otp);
}
