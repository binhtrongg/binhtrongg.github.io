package com.example.mvctest.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotFoundException extends Exception{
    private String errorCode;
    private String errorMessage;
    private LocalDateTime timestamp;
}
