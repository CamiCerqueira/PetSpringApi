package com.btg.PetSpringApi.service;

import com.btg.PetSpringApi.controller.dto.CustomerRequest;
import com.btg.PetSpringApi.controller.dto.CustomerResponse;
import com.btg.PetSpringApi.controller.exception.PasswordValidationError;
import com.btg.PetSpringApi.model.Customer;
import com.btg.PetSpringApi.repository.ICustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

//import com.ada.MeuPrimeiroProjeto.utils.UserConvert;
//import com.ada.MeuPrimeiroProjeto.utils.Validator;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    ICustomer customerRepository;

    public Page<CustomerResponse> getUsers(int page, int size, String direction){
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.fromString(direction), "name");
        Page<Customer> customers = ICustomer.findAll(pageRequest);
        return CustomerConvert.toResponsePage(customers);

    }

    public CustomerResponse saveUser(CustomerRequest userDTO) throws PasswordValidationError {
        Customer customer = CustomerConvert.toEntity(userDTO);
        customer.setActive(true);
        if(!Validator.passwordValidate(customer.getPassword())) throw new PasswordValidationError("Senha deve seguir o padrao");
        Customer userEntity = customerRepository.save(customer);
        return CustomerConvert.toResponse(userEntity);
    }

    public CustomerResponse getUserById(Integer id){
        Optional<Customer> userResponse =  customerRepository.findById(id);
        if(userResponse.isPresent()){
            return CustomerConvert.toResponse(userResponse.get());
        } else {
            throw new RuntimeException("nao encontrado");
        }
    }

    public CustomerResponse getUserByEmail(Integer phoneNumber){
        return CustomerConvert.toResponse(customerRepository.findByPhoneNumber(phoneNumber).get());
    }

    public List<CustomerResponse> getAllByName(String name){
        return CustomerConvert.toResponseList(customerRepository.findAllByName(name));
    }

    public void deleteUser(Integer id){
        Customer customer = customerRepository.findById(id).orElseThrow();
        customer.setActive(false);
        customerRepository.save(customer);
    }

    public CustomerResponse updateUser(Integer id, CustomerRequest userRequest){
        Customer customer = CustomerConvert.toEntity(userRequest);
        customer.setId(id);
        return CustomerConvert.toResponse(customerRepository.save(customer));
    }
}
