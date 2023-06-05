package com.example.driver.entity;
import com.example.driver.model.Person;
import com.example.driver.statics.DriverLicense;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Driver extends Person {
    int id;
    DriverLicense driverLicense;


    public Driver( int id,String name, String address, String phoneNumber, DriverLicense driverLicense) {
        super(name, address, phoneNumber);
        this.id = id;
        this.driverLicense = driverLicense;
    }
}
