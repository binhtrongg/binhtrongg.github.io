package com.example.chonqjetairwebapp.controller;
import com.example.chonqjetairwebapp.entity.Flight;
import com.example.chonqjetairwebapp.model.request.FlightSearchRequest;
import com.example.chonqjetairwebapp.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;

@AllArgsConstructor
@Controller
@RequestMapping("")
public class WebController {

    FlightService flightService;



    @GetMapping("")
    public String web(){
        return "frontend/layout-index";
    }

    @GetMapping("/login")
    public String login(){
        return "frontend/layout-login";
    }

    @GetMapping("/my-profile")
    public String muprofile() {
        return "frontend/layout-my-profile";
    }

    @GetMapping("/admin")
    public String adminProfile(){
        return "admin/db-dashboard";
    }

    @GetMapping("/flights-result")
    public String clientFlightSearch(@RequestParam(value="destination",required = false) String destination,
                                     @RequestParam(value="origin",required = false) String origin,
                                     @RequestParam(value ="departureTime",required = false) String departureTime,
                                     @RequestParam(value = "arrivalTime", required = false) ZonedDateTime arrivalTime,
                                     @RequestParam("numAdults") int numAdults,
                                     @RequestParam("numChildren") int numChildren,
                                     @RequestParam("numInfants") int numInfants,
                                     @RequestParam("cabinClass") String cabinClass,
                                     @RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                                           Model model){
        Page<Flight> pageInfo = flightService.searchFlights(destination,origin,departureTime,arrivalTime,numAdults,numChildren,numInfants,cabinClass,page,pageSize);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("currentPage", page);
        return "frontend/flight-search";
    }

    @GetMapping("/admin/flights")
    public String getAllFlight(@RequestParam(required = false, defaultValue = "1") Integer page,
                               @RequestParam(required = false, defaultValue = "6") Integer pageSize,
                               Model model) {
        Page<Flight> pageInfo = flightService.findAll(page, pageSize);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("currentPage", page);
        return "admin/db-vendor-hotels";
    }


}
