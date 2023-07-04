package com.example.chonqjetairwebapp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ChonqjetairWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChonqjetairWebAppApplication.class, args);
    }

}
