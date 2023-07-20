package com.example.chonqjetairwebapp.repository;

import com.example.chonqjetairwebapp.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport,Long> {
}
