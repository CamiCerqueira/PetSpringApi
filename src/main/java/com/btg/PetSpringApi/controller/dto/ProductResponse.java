package com.btg.PetSpringApi.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
class ProductResponse {
    private Integer id;
    private String name;
    private Double price;
    private TypeProductResponse type;
}
