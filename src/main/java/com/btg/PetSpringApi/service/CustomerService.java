package com.btg.PetSpringApi.service;

import com.btg.PetSpringApi.controller.dto.CustomerRequest;
import com.btg.PetSpringApi.controller.dto.CustomerResponse;
import com.btg.PetSpringApi.controller.exception.PasswordValidationError;
import com.btg.PetSpringApi.model.Customer;
import com.btg.PetSpringApi.repository.ICustomer;
import com.btg.PetSpringApi.utils.CustomerConvert;
import com.btg.PetSpringApi.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    ICustomer customerRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public Page<CustomerResponse> getCustomer(int page, int size, String direction){
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.fromString(direction), "name");
        Page<Customer> customers = customerRepository.findAllActiveCustomers(pageRequest);
        return CustomerConvert.toResponsePage(customers);

    }

    public CustomerResponse saveCustomer(CustomerRequest customerDTO) throws PasswordValidationError {
        Customer customer = CustomerConvert.toEntity(customerDTO);
        customer.setActive(true);
        String encodePassword = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(encodePassword);
        if(!Validator.passwordValidate(customer.getPassword())) throw new PasswordValidationError("Senha deve seguir o padrao");
        Customer CustomerEntity = customerRepository.save(customer);
        return CustomerConvert.toResponse(CustomerEntity);
    }

    public CustomerResponse getCustomerById(Integer id){
        Optional<Customer> customerResponse =  customerRepository.findById(id);
        if(customerResponse.isPresent()){
            return CustomerConvert.toResponse(customerResponse.get());
        } else {
            throw new RuntimeException("nao encontrado");
        }
    }

    public CustomerResponse getCustomerByEmail(String email){
        Customer customer = (Customer) customerRepository.findByEmail(email);
       return CustomerConvert.toResponse(customer);

    }

    public List<CustomerResponse> getAllByName(String name){
        return CustomerConvert.toResponseList(customerRepository.findAllByName(name));
    }

    public void deleteCustomer(Integer id){
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado"));
        customer.setActive(false);
        customerRepository.save(customer);
    }

    public CustomerResponse updateCustomer(Integer id, CustomerRequest customerRequest){
        Customer customer = CustomerConvert.toEntity(customerRequest);
        customer.setId(id);
        return CustomerConvert.toResponse(customerRepository.save(customer));
    }
}
