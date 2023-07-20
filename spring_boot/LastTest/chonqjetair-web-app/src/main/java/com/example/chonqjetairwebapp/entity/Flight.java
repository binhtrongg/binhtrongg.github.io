package com.example.chonqjetairwebapp.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
@Builder
public class Flight extends BaseEntity {
    @Column
    private String name;

    @Column
    private ZonedDateTime departureTime;

    @Column
    private ZonedDateTime arrivalTime;

    @OneToMany(mappedBy = "flight", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @Fetch(FetchMode.SUBSELECT)
    private Set<FlightBooking> bookings = new HashSet<>();

    @ManyToOne
    private AircraftType aircraftType;

    @ManyToOne
    private Airport origin;

    @ManyToOne
    private Airport destination;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private Set<SeatPricing> seatPricings = new HashSet<>();
}