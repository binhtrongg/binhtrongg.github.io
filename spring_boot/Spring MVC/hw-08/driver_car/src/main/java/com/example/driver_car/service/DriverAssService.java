package com.example.driver_car.service;

import com.example.driver_car.entity.Driver;
import com.example.driver_car.entity.DriverAssignment;
import com.example.driver_car.entity.Route;
import com.example.driver_car.model.DriverAssignmentModel;
import com.example.driver_car.model.DriverModel;
import com.example.driver_car.model.RouteModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DriverAssService {
    ObjectMapper objectMapper;
    DriverService driverService;
    RouteService routeService;
    public static List<DriverAssignment> driverAssignments = new ArrayList<>();
    static int autoId = 100;

    public List<DriverAssignmentModel> getDriverAss() {
        List<DriverAssignmentModel> driverAssignmentModels = new ArrayList<>();
        for (DriverAssignment d : driverAssignments) {
            DriverAssignmentModel driverAssignmentModel = DriverAssignmentModel.builder()
                    .id(d.getId())
                    .driverName(d.getDriver().getName())
                    .driverId(d.getDriver().getId())
                    .routeId(d.getRoute().getId())
                    .nums(d.getNums())
                    .build();
            driverAssignmentModels.add(driverAssignmentModel);
        }
        return driverAssignmentModels;
    }

    public void saveDriverAss(DriverAssignmentModel driverAssignmentModel) {
        if (driverAssignmentModel == null) {
            return;
        }
        int driverId = driverAssignmentModel.getDriverId();
        DriverModel driverModel = driverService.findById(driverId);
        Driver driver = objectMapper.convertValue(driverModel, Driver.class);

        int routeId = driverAssignmentModel.getRouteId();
        RouteModel routeModel = routeService.findById(routeId);
        Route route = objectMapper.convertValue(routeModel, Route.class);

        DriverAssignment driverAssignment = DriverAssignment.builder()
                .driver(driver)
                .route(route)
                .nums(driverAssignmentModel.getNums())
                .build();
        ++autoId;
        driverAssignment.setId(autoId);
        driverAssignments.add(driverAssignment);
    }

    public DriverAssignmentModel findById(int id) {
        for (DriverAssignment d : driverAssignments) {
            if (d.getId() == id) {
                return DriverAssignmentModel.builder()
                        .id(d.getId())
                        .driverName(d.getDriver().getName())
                        .driverId(d.getDriver().getId())
                        .routeId(d.getRoute().getId())
                        .nums(d.getNums())
                        .build();
            }
        }
        return null;
    }

    public void updateDriverAss(DriverAssignmentModel driverAssignmentModel) {
        driverAssignments.forEach(driverAssignment -> {
            if (driverAssignment.getId() != driverAssignmentModel.getId()) {
                return;
            }
            DriverModel driverModel=driverService.findById(driverAssignmentModel.getDriverId());
            Driver driver=objectMapper.convertValue(driverModel,Driver.class);

            RouteModel routeModel=routeService.findById(driverAssignmentModel.getRouteId());
            Route route=objectMapper.convertValue(routeModel,Route.class);

            driverAssignment.setDriver(driver);
            driverAssignment.setRoute(route);
            driverAssignment.setNums(driverAssignmentModel.getNums());
        });
    }
}
