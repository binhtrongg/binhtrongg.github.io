package com.example.mvctest.service;

import com.example.mvctest.entity.BookingScheduler;
import com.example.mvctest.model.request.CreatBookingRequest;
import com.example.mvctest.model.request.UpdateStatusRequest;
import com.example.mvctest.repository.BookingRepository;
import com.example.mvctest.statics.Status;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookingService {
    BookingRepository bookingRepository;

    ObjectMapper objectMapper;

    public List<BookingScheduler> getBookings() {
        return bookingRepository.findAll();
    }

    public void save(CreatBookingRequest creatBookingRequest) {
        BookingScheduler bookingScheduler=objectMapper.convertValue(creatBookingRequest,BookingScheduler.class);
        bookingScheduler.setCreatedTime(LocalDateTime.now());
        bookingScheduler.setStatus(Status.PendingApproval);
        bookingRepository.save(bookingScheduler);
    }

    public BookingScheduler findById(Integer id){
        return bookingRepository.findById(id).get();
    }

    public void updateStatus(Integer id, UpdateStatusRequest updateStatusRequest) {
        Optional<BookingScheduler> bookingSchedulerOptional=bookingRepository.findById(id);
        if (bookingSchedulerOptional.isPresent()){
            BookingScheduler bookingScheduler=bookingSchedulerOptional.get();
            bookingScheduler.setUpdateTime(updateStatusRequest.getUpdateTime());
            String statusString = updateStatusRequest.getStatus();
            Status status = Status.valueOf(statusString);
            bookingScheduler.setStatus(status);
            bookingRepository.save(bookingScheduler);
        }
    }
}
