package com.example.chonqjetairwebapp.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FlightSearchRequest extends BaseSearchRequest{
    String destination;
    String origin;
    ZonedDateTime departureTime;
    ZonedDateTime arrivalTime;
    int numAdults;
    int numChildren;
    int numInfants;
    String cabinClass;
}
