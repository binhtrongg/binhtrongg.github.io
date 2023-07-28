package com.example.chonqjetairwebapp.service;

import com.example.chonqjetairwebapp.entity.AircraftType;
import com.example.chonqjetairwebapp.entity.Airport;
import com.example.chonqjetairwebapp.entity.Flight;
import com.example.chonqjetairwebapp.exception.FlightNotFoundException;
import com.example.chonqjetairwebapp.model.request.AdSearchFlightRequest;
import com.example.chonqjetairwebapp.model.request.CreatFlightRequest;
import com.example.chonqjetairwebapp.model.request.FlightSearchRequest;
import com.example.chonqjetairwebapp.model.request.UpdateFlightRequest;
import com.example.chonqjetairwebapp.model.response.CommonResponse;
import com.example.chonqjetairwebapp.model.response.FlightSearchResponse;
import com.example.chonqjetairwebapp.repository.AircraftTypeRepository;
import com.example.chonqjetairwebapp.repository.AirportRepository;
import com.example.chonqjetairwebapp.repository.FlightRepository;
import com.example.chonqjetairwebapp.repository.custom.FlightCustomRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@AllArgsConstructor
@Data
@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private final AircraftTypeRepository aircraftTypeRepository;
    private final AirportRepository airportRepository;
    private final FlightCustomRepository flightCustomRepository;

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


//    public Page<Flight> searchFlights(FlightSearchRequest searchDTO, Integer page, Integer pageSize) {
//        String destination = searchDTO.getDestination();
//        String origin = searchDTO.getOrigin();
//        ZonedDateTime arrivalTime = searchDTO.getArrivalTime();
//        ZonedDateTime departureTime = searchDTO.getDepartureTime();
//        String cabinClass=searchDTO.getCabinClass();
//        int numAdults=searchDTO.getNumAdults();
//        int numChildren=searchDTO.getNumChildren();
//        int numInfants=searchDTO.getNumInfants();
//
//
//        List<Flight> matchingFlights =flightRepository.findFlights(destination,origin,arrivalTime,departureTime,cabinClass);
//
//
//        Pageable pageable = PageRequest.of(page - 1, pageSize);
//        int start = (int) pageable.getOffset();
//        int end = Math.min((start + pageable.getPageSize()), matchingFlights.size());
//        Page<Flight> pageResult = new PageImpl<>(matchingFlights.subList(start, end), pageable, matchingFlights.size());
//
//        return pageResult;
//    }

    public Page<Flight> searchFlights(String destination, String origin, String departureTime, ZonedDateTime arrivalTime, int numAdults, int numChildren, int numInfants, String cabinClass, Integer page, Integer pageSize) {
        List<Flight> matchingFlights =flightRepository.findFlights(destination,origin,partStringtoZoneDateTime(departureTime),arrivalTime,cabinClass);
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), matchingFlights.size());

        return new PageImpl<>(matchingFlights.subList(start, end), pageable, matchingFlights.size());
    }

    public ZonedDateTime partStringtoZoneDateTime(String datestr){
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        return ZonedDateTime.parse(datestr, formatter);
    }


    public CommonResponse<?> searchFlight(FlightSearchRequest request) {
        List<FlightSearchResponse> flights = flightCustomRepository.searchFlight(request);

        Integer pageIndex = request.getPageIndex();
        Integer pageSize = request.getPageSize();
        double pageNumber = Math.ceil((float) flights.size() / pageSize);

//        flights = flights.subList((pageIndex - 1) * pageSize + 1, pageIndex * pageSize + 1);

        return CommonResponse.builder()
                .pageNumber((int) pageNumber)
                .data(flights)
                .build();
    }
}
