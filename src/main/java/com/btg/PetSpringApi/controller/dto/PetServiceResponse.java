package com.btg.PetSpringApi.controller.dto;

import com.btg.PetSpringApi.model.TypePetService;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PetServiceResponse {
    private Integer id;
    private String name;
    private Double price;
    private TypePetService type;
}
