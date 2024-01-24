package com.billing.billing.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column
    @Getter
    @Setter
    private String documentType;

    @Column
    @Getter
    @Setter
    private String document;

    @Column
    @Getter
    @Setter
    private String name;

    @Column
    @Getter
    @Setter
    private String lastName;

    @Column
    @Getter
    @Setter
    private String email;

}
