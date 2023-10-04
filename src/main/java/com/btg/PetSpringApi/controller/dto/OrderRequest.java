package com.btg.PetSpringApi.controller.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class OrderRequest {
    private Double totalPrice;
    private Integer customerId;
    private List<Integer> productsIds;
}
