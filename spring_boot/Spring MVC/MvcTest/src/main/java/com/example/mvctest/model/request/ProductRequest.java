package com.example.mvctest.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductRequest {
    Integer id;
    String name;
    double price;
    String description;
    String avatar;
}
