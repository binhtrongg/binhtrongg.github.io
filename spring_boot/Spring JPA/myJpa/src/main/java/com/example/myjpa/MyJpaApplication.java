package com.example.myjpa;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyJpaApplication.class, args);
    }

    @Bean
    public Faker faker(){
        return new Faker();
    }
}
