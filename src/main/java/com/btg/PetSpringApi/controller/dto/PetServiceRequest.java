package com.btg.PetSpringApi.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PetServiceRequest {
    private String name;
    private Double price;
    private Integer typeId;

}
