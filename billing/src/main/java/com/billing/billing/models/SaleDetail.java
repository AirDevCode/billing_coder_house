package com.billing.billing.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sales_detail")
public class SaleDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @ManyToOne
    @JoinColumn
    @Getter
    @Setter
    private Sale sale;

    @ManyToOne
    @JoinColumn
    @Getter
    @Setter
    private Product product;

    @Column
    @Getter
    @Setter
    private int quantity;

    @Column
    @Getter
    @Setter
    private double subtotal;
}
