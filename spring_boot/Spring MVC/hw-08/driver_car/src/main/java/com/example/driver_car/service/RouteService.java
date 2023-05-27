package com.example.driver_car.service;

import com.example.driver_car.entity.Driver;
import com.example.driver_car.entity.Route;
import com.example.driver_car.model.DriverModel;
import com.example.driver_car.model.RouteModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RouteService {
    ObjectMapper objectMapper;
    public static final List<Route> routes=new ArrayList<>();
    public static int autoId=100;

    public List<RouteModel>getRoutes(){
        List<RouteModel>routeModels=new ArrayList<>();
        for (Route r:routes) {
            RouteModel routeModel=objectMapper.convertValue(r,RouteModel.class);
            routeModels.add(routeModel);
        }
        return routeModels;
    }

    public void saveRoute(RouteModel routeModel) {
        Route route=objectMapper.convertValue(routeModel,Route.class);
        autoId++;
        route.setId(autoId);
        routes.add(route);
    }

    public RouteModel findById(int id) {
        for (Route r : routes) {
            if (r.getId() == id) return objectMapper.convertValue(r,RouteModel.class);
        }
        return null;
    }

    public void updateRoute(RouteModel routeModel) {
        routes.forEach(route -> {
            if (route.getId() != routeModel.getId()) {
                return;
            }
            route.setDistance(routeModel.getDistance());
            route.setStops(routeModel.getStops());
        });
    }

    public void deleteRoute(int id) {
        routes.removeIf(route -> route.getId()==id);
    }
}
