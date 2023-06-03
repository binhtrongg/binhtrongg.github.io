package com.example.myjpa.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name",nullable = false,columnDefinition = "VARCHAR(100)")
    String name;

    @Column(name = "email",nullable = false,unique = true)
    String email;

}
