package com.example.chonqjetairwebapp.repository.custom;

import com.example.chonqjetairwebapp.model.request.FlightSearchRequest;
import com.example.chonqjetairwebapp.model.response.FlightSearchResponse;
import com.example.chonqjetairwebapp.repository.BaseRepository;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FlightCustomRepository extends BaseRepository {
    public List<FlightSearchResponse> searchFlight(FlightSearchRequest request) {
        String sql = "SELECT f.id, f.name, f.departure_time, f.arrival_time, origin_airport.nation " +
                "AS origin_nation, destination_airport.nation " +
                "AS destination_nation, sp.price " +
                "FROM flight f JOIN seat_pricing sp ON f.id = sp.flight_id JOIN airport origin_airport ON f.origin_id = origin_airport.id " +
                "JOIN airport destination_airport ON f.destination_id = destination_airport.id " +
                "JOIN seating_zone sz ON f.aircraft_type_id = sz.aircraft_type_id WHERE 1 = 1";

        Map<String, Object> parameters = new HashMap<>();

        if (request.getDestination() != null && !request.getDestination().trim().equals("")) {
            sql += " AND lower(destination_airport.nation) LIKE :destination";
            parameters.put("destination", "%" + request.getDestination().toLowerCase() + "%");
        }

        if (request.getOrigin() != null && !request.getOrigin().trim().equals("")) {
            sql += " AND lower(origin_airport.nation) LIKE :origin";
            parameters.put("origin", "%" + request.getOrigin().toLowerCase() + "%");
        }

        if (request.getDepartureTime() != null) {
            sql += " AND f.departure_time >= :departureTime";
            parameters.put("departureTime", request.getDepartureTime());
        }

        if (request.getArrivalTime() != null) {
            sql += " AND f.arrival_time <= :arrivalTime";
            parameters.put("arrivalTime", request.getArrivalTime());
        }

        if (request.getCabinClass() != null && !request.getCabinClass().trim().equals("")) {
            sql += " AND lower(sz.cabin_class) LIKE :cabinClass";
            parameters.put("cabinClass", "%" + request.getCabinClass().toLowerCase() + "%");
        }

        return getNamedParameterJdbcTemplate().query(sql, parameters, BeanPropertyRowMapper.newInstance(FlightSearchResponse.class));
    }

}
