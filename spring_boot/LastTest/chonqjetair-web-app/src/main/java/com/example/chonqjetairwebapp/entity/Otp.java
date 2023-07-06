package com.example.chonqjetairwebapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Table
@Data
@Entity
public class Otp extends BaseEntity{
    String otpCode;
    LocalDateTime creatTime;
    LocalDateTime expiredTime;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;
}
