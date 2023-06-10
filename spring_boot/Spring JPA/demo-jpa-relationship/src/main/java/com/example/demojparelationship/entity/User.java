package com.example.demojparelationship.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    private IdentityCard identityCard;

    @OneToMany(mappedBy = "user",cascade =CascadeType.ALL,orphanRemoval = true)
    private List<Post>posts;

    @OneToMany(mappedBy = "user",cascade =CascadeType.ALL,orphanRemoval = true)
    private List<Image> images;
}