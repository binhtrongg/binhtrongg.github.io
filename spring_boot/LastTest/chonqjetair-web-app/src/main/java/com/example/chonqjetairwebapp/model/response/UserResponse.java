package com.example.chonqjetairwebapp.model.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {

    Long id;

    String username;

}
