package com.btg.PetSpringApi.utils;

import com.btg.PetSpringApi.controller.dto.UserEmployeeRequest;
import com.btg.PetSpringApi.controller.dto.UserEmployeeResponse;
import com.btg.PetSpringApi.model.UserEmployee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

public class UserEmployeeConvert {

    public static UserEmployee toEntity(UserEmployeeRequest userEmployeeDTO) {
        UserEmployee userEmployee = new UserEmployee();
        userEmployee.setName(userEmployeeDTO.getName());
        userEmployee.setEmail(userEmployeeDTO.getEmail());
        userEmployee.setPassword(userEmployeeDTO.getPassword());
        return userEmployee;
    }

    public static UserEmployeeResponse toResponse(UserEmployee userEmployee){
        UserEmployeeResponse userEmployeeResponse = new UserEmployeeResponse();
        userEmployeeResponse.setId(userEmployee.getId());
        userEmployee.setName(userEmployee.getName());
        userEmployee.setEmail(userEmployee.getEmail());

        return userEmployeeResponse;

    }
    public static List<UserEmployeeResponse> toResponseList(List<UserEmployee> userEmployees) {
        List<UserEmployeeResponse> userEmployeeResponses = new ArrayList<>();
        for (UserEmployee userEmployee : userEmployees) {
            UserEmployeeResponse userEmployeeResponse = UserEmployeeConvert.toResponse(userEmployee);
            userEmployeeResponses.add(userEmployeeResponse);
        }
        return userEmployeeResponses;
    }

    public static Page<UserEmployeeResponse> toResponsePage(Page<UserEmployee> userEmployees) {
        List<UserEmployeeResponse> userEmployeeResponses = new ArrayList<>();
        for (UserEmployee userEmployee : userEmployees) {
            UserEmployeeResponse userEmployeeResponse = UserEmployeeConvert.toResponse(userEmployee);
            userEmployeeResponses.add(userEmployeeResponse);
        }
        return new PageImpl<>(userEmployeeResponses);
    }
}
