package com.btg.PetSpringApi.controller.dto;

import lombok.Getter;

@Getter
public class PetServiceRequest {
    private String name;
    private Double price;
    private Integer typeId;

}
