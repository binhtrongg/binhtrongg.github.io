package com.example.driver_car.model;

import com.example.driver_car.statics.DriverLicense;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DriverModel extends Person{
    int id;

    @NotNull(message = "Trình Độ Tài Xế Không Được Để Trống")
    DriverLicense driverLicense;


    public DriverModel( int id,String name, String address, String phoneNumber, DriverLicense driverLicense) {
        super(name, address, phoneNumber);
        this.id = id;
        this.driverLicense = driverLicense;
    }
}
