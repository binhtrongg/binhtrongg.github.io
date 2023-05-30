package com.example.driver.model.response;

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
public class DriverReponse extends Person {
    int id;

    DriverLicense driverLicense;


    public DriverReponse(int id, String name, String address, String phoneNumber, DriverLicense driverLicense) {
        super(name, address, phoneNumber);
        this.id = id;
        this.driverLicense = driverLicense;
    }
}
