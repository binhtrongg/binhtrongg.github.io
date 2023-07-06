package com.example.chonqjetairwebapp.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity

public class OtpVerification extends BaseEntity{
    @OneToOne
    @JoinColumn(name = "otp_id")
    Otp otp;
    Boolean verified;
    LocalDateTime verifiedAt;
}
