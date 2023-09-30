package com.btg.PetSpringApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;


@Entity
@Table (name = "orders")
@Getter @Setter


public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double totalPrice;

    @ManyToOne
    private Customer customer;

    @ManyToMany
    private List<Product> products;

    @ManyToMany
    private List<PetService> petServices;
}