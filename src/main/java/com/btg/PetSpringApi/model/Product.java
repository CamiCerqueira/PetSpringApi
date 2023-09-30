package com.btg.PetSpringApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "products")
@Getter @Setter

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private Integer name;

    @Column (name = "price", nullable = false)
    private Integer price;

    @ManyToOne ()
    private TypeProduct type;
}
