package com.example.mvctest.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private Integer id;

    @NotEmpty(message = "Hãy nhập tên sản phẩm")
    private String name;

    @Positive(message = "Giá sản phẩm phải là số dương")
    private double price;

    @NotEmpty(message = "Hãy nhập mô tả sản phẩm")
    private String description;

    @NotEmpty(message = "Hãy nhập đường dẫn avatar")
    private String avatar;
}
