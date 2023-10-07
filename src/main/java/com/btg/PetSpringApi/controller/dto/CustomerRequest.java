package com.btg.PetSpringApi.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Setter @Getter
@AllArgsConstructor
public class CustomerRequest {
    @NotBlank()
    @Length(min = 3, max = 35)
    private String name;
    @Email
    private String email;

    private String password;

    private String pet;

}
