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
public class SeatPricing extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @Enumerated(EnumType.STRING)
    private CabinClass cabinClass;

    @Column
    private int price;

}
