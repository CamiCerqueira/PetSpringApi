package com.btg.PetSpringApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "petservice")
@Getter
@Setter

public class PetService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column (name = "price", nullable = false)
    private Double price;

    @ManyToOne()
    private TypePetService type;
}
