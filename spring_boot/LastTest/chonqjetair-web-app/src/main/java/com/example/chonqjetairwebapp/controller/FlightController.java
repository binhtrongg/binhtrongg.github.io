package com.example.chonqjetairwebapp.controller;

import com.example.chonqjetairwebapp.entity.Flight;
import com.example.chonqjetairwebapp.exception.FlightNotFoundException;
import com.example.chonqjetairwebapp.model.request.CreatFlightRequest;
import com.example.chonqjetairwebapp.model.request.UpdateFlightRequest;
import com.example.chonqjetairwebapp.service.FlightService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/flights")
@Controller
@NoArgsConstructor
@Data
public class FlightController {

    FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }


    @GetMapping
    public String getAllFlight(@RequestParam(required = false, defaultValue = "1") Integer page,
                               @RequestParam(required = false, defaultValue = "6") Integer pageSize,
                               Model model) {
        Page<Flight> pageInfo = flightService.findAll(page, pageSize);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("currentPage", page);
        return "dashboard/db-vendor-hotels";
    }


    @PostMapping
    public ResponseEntity<?> createFlight(@RequestBody CreatFlightRequest creatFlightRequest){
        flightService.creatFlight(creatFlightRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("ok");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateFlight(@RequestBody UpdateFlightRequest updateFlightRequest, @PathVariable("id") Long id) throws FlightNotFoundException {
            updateFlightRequest.setId(id);
            flightService.updateFlight(updateFlightRequest);
            return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFlight(@PathVariable("id") Long id) throws FlightNotFoundException {
            flightService.deleteFlight(id);
            return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}
