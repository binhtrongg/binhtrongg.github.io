package com.example.driver.service;
import com.example.driver.entity.Route;
import com.example.driver.model.request.RouteCreateRequest;
import com.example.driver.model.request.RouteUpdateRequest;
import com.example.driver.model.response.DriverReponse;
import com.example.driver.model.response.RouteResponse;
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

    public List<RouteResponse>getRoutes(){
        List<RouteResponse>routeResponses=new ArrayList<>();
        for (Route r:routes) {
            RouteResponse routeResponse=objectMapper.convertValue(r,RouteResponse.class);
            routeResponses.add(routeResponse);
        }
        return routeResponses;
    }

    public void saveRoute(RouteCreateRequest routeCreateRequest) {
        Route route=objectMapper.convertValue(routeCreateRequest,Route.class);
        autoId++;
        route.setId(autoId);
        routes.add(route);
    }

    public RouteUpdateRequest findById(int id) {
        for (Route r : routes) {
            if (r.getId() == id) return objectMapper.convertValue(r,RouteUpdateRequest.class);
        }
        return null;
    }

    public void updateRoute(RouteUpdateRequest routeModel) {
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
