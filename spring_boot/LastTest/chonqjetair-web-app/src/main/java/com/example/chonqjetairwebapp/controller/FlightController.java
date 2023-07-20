package com.example.chonqjetairwebapp.controller;

import com.example.chonqjetairwebapp.entity.Flight;
import com.example.chonqjetairwebapp.exception.FlightNotFoundException;
import com.example.chonqjetairwebapp.model.request.CreatFlightRequest;
import com.example.chonqjetairwebapp.model.request.UpdateFlightRequest;
import com.example.chonqjetairwebapp.repository.AircraftTypeRepository;
import com.example.chonqjetairwebapp.repository.AirportRepository;
import com.example.chonqjetairwebapp.service.FlightService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("")
@Controller
@NoArgsConstructor
@Data
public class FlightController {

    FlightService flightService;

    AircraftTypeRepository aircraftTypeRepository;

    AirportRepository airportRepository;

    @Autowired
    public FlightController(FlightService flightService,AircraftTypeRepository aircraftTypeRepository,AirportRepository airportRepository) {
        this.aircraftTypeRepository=aircraftTypeRepository;
        this.airportRepository=airportRepository;
        this.flightService = flightService;
    }


    @GetMapping("/flight")
    public String getAllFlight(@RequestParam(required = false, defaultValue = "1") Integer page,
                               @RequestParam(required = false, defaultValue = "6") Integer pageSize,
                               Model model) {
        Page<Flight> pageInfo = flightService.findAll(page, pageSize);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("currentPage", page);
        return "admin/db-vendor-hotels";
    }


    @GetMapping("/add-flight")
    public String getAllFlight(Model model) {
        model.addAttribute("aircraftType",aircraftTypeRepository.findAll());
        model.addAttribute("airportList", airportRepository.findAll());
        return "admin/db-vendor-add-hotel";
    }



    @PostMapping("/api/v1/flights")
    public ResponseEntity<?> createFlight(@RequestBody CreatFlightRequest creatFlightRequest){
        flightService.creatFlight(creatFlightRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("ok");
    }


    @PutMapping("/api/v1/flights/update/{id}")
    public ResponseEntity<?> updateFlight(@RequestBody UpdateFlightRequest updateFlightRequest, @PathVariable("id") Long id) throws FlightNotFoundException {
            updateFlightRequest.setId(id);
            flightService.updateFlight(updateFlightRequest);
            return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/api/v1/flights/delete/{id}")
    public ResponseEntity<?> deleteFlight(@PathVariable("id") Long id) throws FlightNotFoundException {
            flightService.deleteFlight(id);
            return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}
