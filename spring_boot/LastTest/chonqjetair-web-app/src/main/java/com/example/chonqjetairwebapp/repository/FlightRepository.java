package com.example.chonqjetairwebapp.repository;
import com.example.chonqjetairwebapp.entity.Flight;
import com.example.chonqjetairwebapp.statics.CabinClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,Long> {


   @Query("SELECT f FROM Flight f WHERE "
           + "(:name IS NULL OR f.name LIKE %:name%) "
           + "AND (:arrivalTime IS NULL OR f.arrivalTime < :arrivalTime) "
           + "AND (:departureTime IS NULL OR f.departureTime > :departureTime) "
           + "AND (:from IS NULL OR f.destination.nation LIKE %:from%) "
           + "AND (:to IS NULL OR f.origin.nation LIKE %:to%)")
   List<Flight> searchFlight(@Param("name") String name,
                             @Param("departureTime") ZonedDateTime departureTime,
                             @Param("arrivalTime") ZonedDateTime arrivalTime,
                             @Param("from") String from,
                             @Param("to") String to);


   @Query("SELECT f FROM Flight f " +
           "JOIN SeatingZone sz ON f.aircraftType.id = sz.aircraftType.id " +
           "WHERE (:destination IS NULL OR :destination = '' OR f.destination.nation = :destination) " +
           "AND (:origin IS NULL OR :origin = '' OR f.origin.nation = :origin) " +
           "AND (:arrivalTime IS NULL OR f.arrivalTime >= :arrivalTime) " +
           "AND (:departureTime IS NULL OR f.departureTime <= :departureTime) " +
           "AND (:cabinClass IS NULL OR :cabinClass = '' OR sz.cabinClass = :cabinClass)")
   List<Flight> findFlights(@Param("destination") String destination,
                            @Param("origin") String origin,
                            @Param("arrivalTime") ZonedDateTime arrivalTime,
                            @Param("departureTime") ZonedDateTime departureTime,
                            @Param("cabinClass") String cabinClass);


//                            @Param("numAdults") int numAdults,
//                            @Param("numChildren") int numChildren,
//                            @Param("numInfants") int numInfants);

}
