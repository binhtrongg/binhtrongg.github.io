package com.example.chonqjetairwebapp.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
public class FlightBooking extends BaseEntity{

    @ManyToOne
    private Flight flight;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;
    @OneToOne(mappedBy = "flightBooking")
    Payment payment;

    @OneToMany(mappedBy = "flightBooking",cascade = CascadeType.ALL)
    private Set<SeatBookingDetail> seatBookingDetails = new HashSet<>();
}
