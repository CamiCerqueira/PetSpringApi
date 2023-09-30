package com.btg.PetSpringApi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
@Entity
@Table (name = "pet")


public class Pet {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "name", nullable = false)
    private Integer name;

    @Column (name = "age", nullable = false)
    private Integer age;

    @Column (name = "weight", nullable = false)
    private Integer weight;

    @Column (name = "breed", nullable = false)
    private Integer breed;

}
