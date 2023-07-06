package com.example.chonqjetairwebapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.mail.MailParseException;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class Seat extends BaseEntity {
    @OneToOne(mappedBy = "seat")
    SeatBookingDetail seatBookingDetail;

    @Column
    private int rowNumber;

    @Column
    private String letterCode;

    @Column
    private int price;
}