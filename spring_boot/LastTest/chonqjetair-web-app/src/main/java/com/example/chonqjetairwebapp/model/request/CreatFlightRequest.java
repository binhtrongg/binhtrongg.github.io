package com.example.chonqjetairwebapp.model.request;

import com.example.chonqjetairwebapp.entity.AircraftType;
import com.example.chonqjetairwebapp.entity.Airport;
import com.example.chonqjetairwebapp.entity.FlightBooking;
import com.example.chonqjetairwebapp.entity.SeatPricing;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CreatFlightRequest {
    private String name;

    private ZonedDateTime departureTime;

    private ZonedDateTime arrivalTime;



    private Long aircraftTypeId;

    private Long originId;

    private Long destinationId;

}
