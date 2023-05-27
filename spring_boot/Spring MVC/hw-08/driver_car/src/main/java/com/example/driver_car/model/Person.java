package com.example.driver_car.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PROTECTED)
public class Person {
    @Size(max = 100,message ="Tên  Không Vượt Quá 100 Kí Tự" )
    @NotBlank(message = "Tên  Không Được Để Trống")
    String name;

    @Size(max = 255,message ="Địa Chỉ Không Vượt Quá 255 Kí Tự" )
    @NotBlank(message = "Địa Chỉ Không Được Để Trống")
    String address;

    @Pattern(regexp = "\\d{10}", message = "Số Điện Thoại Bao Gồm 10 Kí Tự Số")
    String phoneNumber;
}
