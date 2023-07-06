package com.example.chonqjetairwebapp.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Passenger extends BaseEntity{
    @OneToOne(mappedBy = "passenger")
    SeatBookingDetail seatBookingDetail;

    String name;

    LocalDateTime dob;

    String nationality;

    String passpostCode;

}
