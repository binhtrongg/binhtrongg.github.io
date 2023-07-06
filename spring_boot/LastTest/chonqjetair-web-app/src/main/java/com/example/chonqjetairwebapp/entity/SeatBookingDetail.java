package com.example.chonqjetairwebapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class SeatBookingDetail extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "flight_booking_id")
    private FlightBooking flightBooking;

    @OneToOne
            @JoinColumn(name = "passenger_id")
    Passenger passenger;

    @JoinColumn(name = "seat_id")
    @OneToOne
    Seat seat;
}
