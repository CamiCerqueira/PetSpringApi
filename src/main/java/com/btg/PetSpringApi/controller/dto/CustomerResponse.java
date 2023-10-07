package com.btg.PetSpringApi.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CustomerResponse {
    private Integer id;
    private String name;
    private String email;
    private String pet;
}
