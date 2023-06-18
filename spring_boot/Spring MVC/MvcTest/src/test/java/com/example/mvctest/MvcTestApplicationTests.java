package com.example.mvctest;

import com.example.mvctest.entity.Product;
import com.example.mvctest.repository.ProductRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MvcTestApplicationTests {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    Faker faker;


}
