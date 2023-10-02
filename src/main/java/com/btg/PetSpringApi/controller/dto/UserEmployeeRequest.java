package com.btg.PetSpringApi.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
@Getter @Setter
@AllArgsConstructor
public class UserEmployeeRequest {
    @NotBlank()
    @Length(min = 3, max = 35)
    private String name;
    @Email
    private String email;

    private String password;
}
