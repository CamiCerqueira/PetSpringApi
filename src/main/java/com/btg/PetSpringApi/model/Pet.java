package com.btg.PetSpringApi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table (name = "pet")
@Where(clause = "active is true")
public class Pet {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "name", nullable = false)
    private String name;

    @Column (name = "age", nullable = false)
    private Double age;

    @Column (name = "weight", nullable = false)
    private Double weight;

    @Column (name = "breed", nullable = false)
    private String breed;

    private Boolean active;

}