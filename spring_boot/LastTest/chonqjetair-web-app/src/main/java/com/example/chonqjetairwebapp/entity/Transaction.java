package com.example.chonqjetairwebapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Entity
public class Transaction extends BaseEntity{

    @OneToOne(mappedBy = "transaction")
    Payment payment;

    @Column(name = "transaction_type")
    private String transactionType;

    LocalDateTime transactionTime;

    private String transactionStatus;
}
