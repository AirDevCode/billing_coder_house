package com.billing.billing.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column
    @Getter
    @Setter
    private String product_code;

    @Column
    @Getter
    @Setter
    private String name;

    @Column
    @Getter
    @Setter
    private double price;

    @Column
    @Getter
    @Setter
    private String description;

    @Column
    @Getter
    @Setter
    private int stock;
}
