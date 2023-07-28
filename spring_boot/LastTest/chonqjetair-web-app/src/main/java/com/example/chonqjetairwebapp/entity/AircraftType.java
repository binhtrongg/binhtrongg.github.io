package com.example.chonqjetairwebapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
public class AircraftType extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "aircraftType", orphanRemoval = true)
    @JsonIgnore
    private Set<SeatingZone> seatingZones = new HashSet<>();
}
