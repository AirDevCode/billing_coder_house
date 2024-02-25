package com.billing.billing.models;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column
    @Getter
    @Setter
    private Date date;

    @ManyToOne
    @JoinColumn
    @Getter
    @Setter
    private Client client;

    @JoinColumn
    @Getter
    @Setter
    private double sale_value;

    @Column
    @Getter
    @Setter
    private double total;

    @Column
    @Getter
    @Setter
    private int total_products;

}
