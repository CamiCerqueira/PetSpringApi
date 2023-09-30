package com.btg.PetSpringApi.model;

import jakarta.persistence.*;

public class PetService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private Integer name;

    @Column (name = "price", nullable = false)
    private Integer price;

    @ManyToOne()
    private TypePetService type;
}
