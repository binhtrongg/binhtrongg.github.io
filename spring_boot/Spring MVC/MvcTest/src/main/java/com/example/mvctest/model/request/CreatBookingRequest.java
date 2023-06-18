package com.example.mvctest.model.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreatBookingRequest {
    Integer id;

    @NotEmpty(message = "Tên người dùng không được để trống")
    String username;

    @NotEmpty(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    String email;

    @NotEmpty(message = "Số điện thoại không được để trống")
    @Size(min = 10, max = 10, message = "Số điện thoại phải có 10 chữ số")
    String phoneNumber;

    String appointmentDetails;
}
