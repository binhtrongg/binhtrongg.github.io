package com.example.driver_car.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DriverAssignmentModel {
    int id;
    int driverId;
    String driverName;
    int routeId;

    @NotNull(message = "không Được Để Trống")
    @Range(min = 0,max = 15,message = "số lượt lái từ 0 đến 15")
    int nums;
}
