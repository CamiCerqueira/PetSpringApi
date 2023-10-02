package com.btg.PetSpringApi.service;

import com.btg.PetSpringApi.controller.dto.UserEmployeeRequest;
import com.btg.PetSpringApi.controller.dto.UserEmployeeResponse;
import com.btg.PetSpringApi.controller.exception.PasswordValidationError;
import com.btg.PetSpringApi.model.UserEmployee;
import com.btg.PetSpringApi.utils.UserEmployeeConvert;
import com.btg.PetSpringApi.utils.Validator;
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
    UserEmployeeService userEmployeeRepository;

    public Page<UserEmployeeResponse> getUsers(int page, int size, String direction){
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.fromString(direction), "name");
        Page<UserEmployee> userEmployees = userEmployeeRepository.findAll(pageRequest);
        return UserEmployeeConvert.toResponsePage(userEmployees);

    }

    public UserEmployeeResponse saveUser(UserEmployeeRequest userDTO) throws PasswordValidationError {
        UserEmployee user = UserEmployeeConvert.toEntity(userDTO);
        user.setActive(true);
        if(!Validator.passwordValidate(user.getPassword())) throw new PasswordValidationError("Senha deve seguir o padrao");
        UserEmployee userEntity = userEmployeeRepository.save(userEmployee);
        return UserEmployeeConvert.toResponse(userEntity);
    }

    public UserEmployeeResponse getUserById(Integer id){
        Optional<UserEmployee> userResponse =  userEmployeeRepository.findById(id);
        if(userResponse.isPresent()){
            return UserEmployeeConvert.toResponse(userResponse.get());
        } else {
            throw new RuntimeException("nao encontrado");
        }
    }

    public UserEmployeeResponse getUserByEmail(String email){
        return UserEmployeeConvert.toResponse(userEmployeeRepository.findByEmail(email).get());
    }

    public List<UserEmployeeResponse> getAllByName(String name){
        return UserEmployeeConvert.toResponseList(userEmployeeRepository.findAllByName(name));
    }

    public void deleteUser(Integer id){
        UserEmployee userEmployee = userEmployeeRepository.findById(id).orElseThrow();
        user.setActive(false);
        userEmployeeRepository.save(user);
    }

    public UserEmployeeResponse updateUser(Integer id, UserEmployeeRequest userRequest){
        UserEmployee userEmkployee = UserEmployeeConvert.toEntity(userRequest);
        userEmkployee.setId(id);
        return UserEmployeeConvert.toResponse(userEmployeeRepository.save(userEmkployee));
    }

}
