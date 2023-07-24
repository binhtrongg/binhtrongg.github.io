package com.example.chonqjetairwebapp.service;

import com.example.chonqjetairwebapp.entity.AircraftType;
import com.example.chonqjetairwebapp.entity.Airport;
import com.example.chonqjetairwebapp.entity.Flight;
import com.example.chonqjetairwebapp.exception.FlightNotFoundException;
import com.example.chonqjetairwebapp.model.request.AdSearchFlightRequest;
import com.example.chonqjetairwebapp.model.request.CreatFlightRequest;
import com.example.chonqjetairwebapp.model.request.UpdateFlightRequest;
import com.example.chonqjetairwebapp.repository.AircraftTypeRepository;
import com.example.chonqjetairwebapp.repository.AirportRepository;
import com.example.chonqjetairwebapp.repository.FlightRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Data
@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private final AircraftTypeRepository aircraftTypeRepository;
    private final AirportRepository airportRepository;

    public void creatFlight(CreatFlightRequest creatFlightRequest) {
        Flight flight = Flight.builder()
                .name(creatFlightRequest.getName())
                .aircraftType(aircraftTypeRepository.findById(creatFlightRequest.getAircraftTypeId()).orElseThrow())
                .arrivalTime(creatFlightRequest.getArrivalTime())
                .departureTime(creatFlightRequest.getDepartureTime())
                .origin(airportRepository.findById(creatFlightRequest.getOriginId()).orElseThrow())
                .destination(airportRepository.findById(creatFlightRequest.getDestinationId()).orElseThrow())
                .build();
        flightRepository.save(flight);
    }

    public void updateFlight(UpdateFlightRequest updateFlightRequest) throws FlightNotFoundException {
        Flight flight = flightRepository.findById(updateFlightRequest.getId()).orElseThrow(FlightNotFoundException::new);
        flight.setName(updateFlightRequest.getName());
        flight.setAircraftType(aircraftTypeRepository.findById(updateFlightRequest.getAircraftTypeId()).orElseThrow());
        flight.setArrivalTime(updateFlightRequest.getArrivalTime());
        flight.setDepartureTime(updateFlightRequest.getDepartureTime());
        flight.setOrigin(airportRepository.findById(updateFlightRequest.getOriginId()).orElseThrow());
        flight.setDestination(airportRepository.findById(updateFlightRequest.getDestinationId()).orElseThrow());
        flightRepository.save(flight);
    }

    public void deleteFlight(Long id) throws FlightNotFoundException {
        Flight flight = flightRepository.findById(id).orElseThrow(FlightNotFoundException::new);
        flightRepository.delete(flight);
    }

    public Page<Flight> findAll(Integer page, Integer pageSize) {
            Pageable pageRequest = PageRequest.of(page - 1, pageSize);
            return flightRepository.findAll(pageRequest);
    }

    public List<AircraftType> getAllAircraft(){
        return aircraftTypeRepository.findAll();
    }
    public List<Airport> getAllAirport(){
        return airportRepository.findAll();
    }

    public List<Flight> searchFlight(AdSearchFlightRequest searchRequest) {
      return flightRepository.searchFlight(searchRequest.getName(),searchRequest.getDepartureTime(),searchRequest.getArrivalTime(),searchRequest.getFrom(),searchRequest.getTo());
    }
}
