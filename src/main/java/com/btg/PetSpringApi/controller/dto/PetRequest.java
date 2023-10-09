package com.btg.PetSpringApi.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;


@Setter
@Getter
@AllArgsConstructor
public class PetRequest {

    @NotBlank()
    @Length(min = 3, max = 35)
    private String name;
    //@Email
    //private String email;

    private String breed;

    private Double age;

    private Double weight;

    //private String password;
}