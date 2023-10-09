package com.btg.PetSpringApi.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Setter
@Getter
@AllArgsConstructor
public class PetRequest {

    @NotBlank()
    @Length(min = 3, max = 35)
    private String name;

    private String breed;

    private Double age;

    private Double weight;
}