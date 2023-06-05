package com.example.driver.service;
import com.example.driver.entity.Driver;
import com.example.driver.model.request.DriverCreateRequest;
import com.example.driver.model.request.DriverUpdateRequest;
import com.example.driver.model.response.DriverReponse;
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

   public List<DriverReponse>getDrivers(){
       List<DriverReponse>driverReponses=new ArrayList<>();
       for (Driver d:drivers) {
           DriverReponse driverReponse=objectMapper.convertValue(d,DriverReponse.class);
           driverReponses.add(driverReponse);
       }
       return driverReponses;
   }

    public void saveDriver(DriverCreateRequest newDriver) {
       Driver driver=objectMapper.convertValue(newDriver,Driver.class);
       autoId++;
       driver.setId(autoId);
       drivers.add(driver);

    }

    public DriverReponse findById(int id) {
        for (Driver d : drivers) {
            if (d.getId() == id) return objectMapper.convertValue(d,DriverReponse.class);
        }
        return null;
    }

    public void updateDriver(DriverUpdateRequest driverModel) {
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
