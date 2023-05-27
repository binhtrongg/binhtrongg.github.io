package com.example.driver_car.service;

import com.example.driver_car.entity.Driver;
import com.example.driver_car.model.DriverModel;
import com.example.driver_car.statics.DriverLicense;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DriverService {
    ObjectMapper objectMapper;
   public static final List<Driver> drivers=new ArrayList<>();
   public static int autoId=10000;

   public List<DriverModel>getDrivers(){
       List<DriverModel>driverModels=new ArrayList<>();
       for (Driver d:drivers) {
           DriverModel driverModel=objectMapper.convertValue(d,DriverModel.class);
           driverModels.add(driverModel);
       }
       return driverModels;
   }

    public void saveDriver(DriverModel driverModel) {
       Driver driver=objectMapper.convertValue(driverModel,Driver.class);
       autoId++;
       driver.setId(autoId);
       drivers.add(driver);

    }

    public DriverModel findById(int id) {
        for (Driver d : drivers) {
            if (d.getId() == id) return objectMapper.convertValue(d,DriverModel.class);
        }
        return null;
    }

    public void updateDriver(DriverModel driverModel) {
        drivers.forEach(driver -> {
            if (driver.getId() != driverModel.getId()) {
                return;
            }
            driver.setName(driverModel.getName());
            driver.setAddress(driverModel.getAddress());
            driver.setPhoneNumber(driverModel.getPhoneNumber());
            driver.setDriverLicense(driverModel.getDriverLicense());
        });
    }

    public void deleteDriver(int id) {
       drivers.removeIf(driver -> driver.getId()==id);
    }
}
