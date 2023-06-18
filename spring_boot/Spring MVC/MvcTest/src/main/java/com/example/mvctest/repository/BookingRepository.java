package com.example.mvctest.repository;

import com.example.mvctest.entity.BookingScheduler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingScheduler,Integer> {
}
