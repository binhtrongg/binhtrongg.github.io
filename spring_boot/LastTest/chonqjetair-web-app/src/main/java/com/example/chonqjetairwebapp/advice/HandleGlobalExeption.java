package com.example.chonqjetairwebapp.advice;

import com.example.chonqjetairwebapp.exception.FlightNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class HandleGlobalExeption {

    @ExceptionHandler(FlightNotFoundException.class)
    public ResponseEntity<?> handleFlightNotFoundException(FlightNotFoundException flightNotFoundException){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight Not Found");
    }

}
