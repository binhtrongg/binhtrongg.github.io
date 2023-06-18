package com.example.mvctest.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    double price;

    String description;

    String avatar;
}
