package com.example.chonqjetairwebapp.model.response;

import com.example.chonqjetairwebapp.entity.AircraftType;
import com.example.chonqjetairwebapp.entity.Airport;
import com.example.chonqjetairwebapp.entity.FlightBooking;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlightSearchResponse extends CommonResponse{
    private String name;
    private ZonedDateTime departureTime;
    private ZonedDateTime arrivalTime;
    private AircraftType aircraftType;
    private String origin_nation;
    private String destination_nation;
    private int price;
}
