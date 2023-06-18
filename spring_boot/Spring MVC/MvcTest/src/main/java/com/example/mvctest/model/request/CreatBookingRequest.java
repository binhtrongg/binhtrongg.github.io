package com.example.mvctest.model.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreatBookingRequest {
    Integer id;

    String username;

    String email;

    String phoneNumber;

    String appointmentDetails;

}
