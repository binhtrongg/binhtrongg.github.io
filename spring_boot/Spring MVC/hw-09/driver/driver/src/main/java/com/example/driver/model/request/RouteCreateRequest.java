package com.example.driver.model.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RouteCreateRequest {
    int id;

    @NotNull(message = "Khoảng cách không được để trống")
    @Positive(message = "Khoảng cách phải là số dương")
    int distance;

    @NotNull(message = "Số điểm dừng không được để trống")
    @Min(value = 1, message = "Số điểm dừng phải lớn hơn hoặc bằng 1")
    int stops;
}
