package com.example.driver_car.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DriverAssignment {
    int id;
    Driver driver;
    Route route;
    int nums;
}
