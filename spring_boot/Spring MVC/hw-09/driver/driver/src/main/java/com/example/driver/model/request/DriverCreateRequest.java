package com.example.driver.model.request;

import com.example.driver.model.Person;
import com.example.driver.statics.DriverLicense;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DriverCreateRequest extends Person {
    int id;

    @NotNull(message = "Trình Độ Tài Xế Không Được Để Trống")
    DriverLicense driverLicense;


    public DriverCreateRequest(int id, String name, String address, String phoneNumber, DriverLicense driverLicense) {
        super(name, address, phoneNumber);
        this.id = id;
        this.driverLicense = driverLicense;
    }
}
