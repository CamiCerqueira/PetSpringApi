package com.btg.PetSpringApi.controller.dto;

import com.btg.PetSpringApi.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class OrderResponse {
    private Integer id;
    private Double totalPrice;
    private String Customer;
    private List<Product> products;
}
