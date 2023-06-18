package com.example.mvctest.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateStatusRequest {
    Integer id;

    String status;

    LocalDateTime updateTime;
}
