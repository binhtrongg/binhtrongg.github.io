package com.example.mvctest.controller;

import com.example.mvctest.entity.BookingScheduler;
import com.example.mvctest.model.request.CreatBookingRequest;
import com.example.mvctest.model.request.UpdateStatusRequest;
import com.example.mvctest.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
@AllArgsConstructor
public class BookingController {
    BookingService bookingService;

    @PostMapping("/api/v1/bookings")
    public ResponseEntity<?> creatBooking(@RequestBody CreatBookingRequest creatBookingRequest){
        bookingService.save(creatBookingRequest);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/api/v1/bookings/{id}")
    public ResponseEntity<?> updateBooking(@PathVariable Integer id, @RequestBody UpdateStatusRequest updateStatusRequest){
        bookingService.updateStatus(id,updateStatusRequest);
        BookingScheduler bookingScheduler= bookingService.findById(id);
        return ResponseEntity.ok(bookingScheduler.getEmail());
    }
}
