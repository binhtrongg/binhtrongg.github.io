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
public class AdSearchFlightRequest {
    String name;
    ZonedDateTime departureTime;

    ZonedDateTime arrivalTime;
    String from;
    String to;
}
