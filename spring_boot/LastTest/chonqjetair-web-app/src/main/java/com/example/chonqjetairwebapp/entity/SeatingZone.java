package com.example.chonqjetairwebapp.entity;
import com.example.chonqjetairwebapp.statics.CabinClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SeatingZone extends BaseEntity{

    @Column
    private int startingRowNumber;

    @Column
    private int numRows;

    @Enumerated(EnumType.STRING)
    private CabinClass cabinClass;

    @Column
    private String seatCodeData;

    @ManyToOne
    @JoinColumn(name = "aircraft_type_id")
    private AircraftType aircraftType;
}
