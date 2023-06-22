package com.example.demo.model.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseRequest {
    @NotBlank(message = "Tên không được để trống")
    String name;

    @NotBlank(message = "Mô tả không được để trống")
    String description;

    @NotBlank(message = "Loại không được để trống")
    String type;

    @NotNull(message = "Danh sách topic không được null")
    @Size(min = 1, message = "Phải có ít nhất một topic")
    List<Integer> topicIds;

    @NotNull(message = "Supporter ID không được null")
    Integer supporterId;
}
