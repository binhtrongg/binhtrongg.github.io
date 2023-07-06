package com.example.chonqjetairwebapp.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment extends BaseEntity{
    @OneToOne
    @JoinColumn(name = "flight_booking_id")
    FlightBooking flightBooking;

    double money;

    String paymentStatus;

    String paymentMethod;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transaction_id")
    Transaction transaction;

    LocalDateTime createdAt;
}
