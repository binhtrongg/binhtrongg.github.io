package com.example.jpareview.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Supporter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    String name;

    @Column(unique = true,nullable = false)
    String email;

    @Column(nullable = false)
    String phone;

    String avatar;

    @OneToMany(mappedBy = "supporter",orphanRemoval = true)
    List<Cource> cources;



}
