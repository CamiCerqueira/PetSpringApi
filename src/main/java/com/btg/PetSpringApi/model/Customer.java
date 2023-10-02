package com.btg.PetSpringApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table (name="customer")
@Where(clause = "active is true")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column (name = "pet", nullable = false)
    private String pet;

    @Column (name = "phoneNumber", nullable = false)
    private String phoneNumber;
    private Boolean active;

    @Column(name = "password",nullable = false)
    private String password;
}


