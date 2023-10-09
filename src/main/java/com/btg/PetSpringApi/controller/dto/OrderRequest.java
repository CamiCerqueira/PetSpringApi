package com.btg.PetSpringApi.controller.dto;

import com.btg.PetSpringApi.model.Customer;
import com.btg.PetSpringApi.model.PetService;
import com.btg.PetSpringApi.model.Product;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class OrderRequest {

    private Double totalPrice;
    private Integer customerId;
    private List<Integer> productId;
    private List<Integer> petServicesId;

}


