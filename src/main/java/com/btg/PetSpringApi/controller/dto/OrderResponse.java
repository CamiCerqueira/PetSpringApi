package com.btg.PetSpringApi.controller.dto;

import com.btg.PetSpringApi.model.Customer;
import com.btg.PetSpringApi.model.PetService;
import com.btg.PetSpringApi.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class OrderResponse {
    private Integer id;
    private Double totalPrice;
    private Customer customer;
    private List<Product> productId;
    private List<PetService> petServiceId;
}


