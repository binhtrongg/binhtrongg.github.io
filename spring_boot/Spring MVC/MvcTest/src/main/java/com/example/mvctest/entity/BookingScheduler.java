package com.example.mvctest.entity;


import com.example.mvctest.statics.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "booking_scheduler")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingScheduler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String username;

    @Column(nullable = false,unique = true)
    String email;

    String phoneNumber;

    String appointmentDetails;

    @Enumerated(EnumType.ORDINAL)
    Status status;

    LocalDateTime createdTime;

    LocalDateTime updateTime;
}
