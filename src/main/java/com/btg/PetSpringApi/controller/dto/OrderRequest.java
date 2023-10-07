package com.btg.PetSpringApi.controller.dto;

import com.btg.PetSpringApi.model.Customer;
import com.btg.PetSpringApi.model.PetService;
import com.btg.PetSpringApi.model.Product;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

import java.util.List;

@Getter
public class OrderRequest {

    private Double totalPrice;
    private Integer customerId;
    private List<Product> products;
    private List<PetService> petServices;

}


