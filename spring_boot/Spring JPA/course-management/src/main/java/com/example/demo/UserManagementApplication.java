package com.example.demo;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserManagementApplication.class, args);
    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }
    @Bean
    public Faker faker() {
        return new Faker();
    }
}
