package com.example.myjpa.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "todo")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "title")
    String title;

    @Column(name = "status")
    Boolean status;
}
