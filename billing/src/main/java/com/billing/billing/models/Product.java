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
    private String productCode;

    @Column
    @Getter
    @Setter
    private String name;

    @Column
    @Getter
    @Setter
    private String price;

    @Column
    @Getter
    @Setter
    private String description;
}
