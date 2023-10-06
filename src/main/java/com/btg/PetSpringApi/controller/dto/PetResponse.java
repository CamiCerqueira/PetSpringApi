package com.btg.PetSpringApi.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class PetResponse {
    private Integer id;
    private String name;
    private String breed;

}
