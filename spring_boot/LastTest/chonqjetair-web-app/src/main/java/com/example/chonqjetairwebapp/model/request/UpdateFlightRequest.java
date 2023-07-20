package com.example.chonqjetairwebapp.model.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.time.ZonedDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class UpdateFlightRequest {
    private Long id;
    private String name;

    private ZonedDateTime departureTime;

    private ZonedDateTime arrivalTime;



    private Long aircraftTypeId;

    private Long originId;

    private Long destinationId;
}
