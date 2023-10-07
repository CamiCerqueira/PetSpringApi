package com.btg.PetSpringApi.service;

import com.btg.PetSpringApi.controller.dto.UserEmployeeRequest;
import com.btg.PetSpringApi.controller.dto.UserEmployeeResponse;
import com.btg.PetSpringApi.controller.exception.PasswordValidationError;
import com.btg.PetSpringApi.model.QUserEmployee;
import com.btg.PetSpringApi.model.UserEmployee;
import com.btg.PetSpringApi.repository.IUserEmployee;
import com.btg.PetSpringApi.utils.UserEmployeeConvert;
import com.btg.PetSpringApi.utils.Validator;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserEmployeeService {
    @Autowired
    IUserEmployee userEmployeeRepository;

    public Page<UserEmployeeResponse> getUserEmployee(int page, int size, String direction){
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.fromString(direction), "name");
        Page<UserEmployee> userEmployees = userEmployeeRepository.findAllActiveUserEmployees(pageRequest);
        return UserEmployeeConvert.toResponsePage(userEmployees);

    }

    public UserEmployeeResponse saveUserEmployee(UserEmployeeRequest userEmployeeDTO) throws PasswordValidationError {
        UserEmployee userEmployee = UserEmployeeConvert.toEntity(userEmployeeDTO);
        userEmployee.setActive(true);
        if(!Validator.passwordValidate(userEmployee.getPassword())) throw new PasswordValidationError("Senha deve seguir o padrao");
        UserEmployee userEmployeeEntity = userEmployeeRepository.save(userEmployee);
        return UserEmployeeConvert.toResponse(userEmployeeEntity);
    }

    public UserEmployeeResponse getUserEmployeeById(Integer id){
        Optional<UserEmployee> userEmployeeResponse =  userEmployeeRepository.findById(id);
        if(userEmployeeResponse.isPresent()){
            return UserEmployeeConvert.toResponse(userEmployeeResponse.get());
        } else {
            throw new RuntimeException("nao encontrado");
        }
    }

    public UserEmployeeResponse getUserEmployeeByEmail(String email){
        QUserEmployee qUserEmployee = QUserEmployee.userEmployee;
        BooleanExpression booleanExpression = qUserEmployee.email.eq(qUserEmployee.email);
        return UserEmployeeConvert.toResponse(userEmployeeRepository.findOne(booleanExpression).get());
    }

    public List<UserEmployeeResponse> getAllByName(String name){

        return UserEmployeeConvert.toResponseList(userEmployeeRepository.findAllByName(name));
    }

    public void deleteUserEmployee(Integer id) {
        Optional<UserEmployee> userEmployeeOptional = userEmployeeRepository.findById(id);

        if (userEmployeeOptional.isPresent()) {
            UserEmployee userEmployee = userEmployeeOptional.get();
            userEmployee.setActive(false);
            userEmployeeRepository.save(userEmployee);
        } else {
            throw new RuntimeException("O Usuário " + id + " Não foi encontrado");
        }
    }


    public UserEmployeeResponse updateUserEmployee(Integer id, UserEmployeeRequest userRequest){
        UserEmployee userEmployee = UserEmployeeConvert.toEntity(userRequest);
        userEmployee.setId(id);
        return UserEmployeeConvert.toResponse(userEmployeeRepository.save(userEmployee));
    }

}
