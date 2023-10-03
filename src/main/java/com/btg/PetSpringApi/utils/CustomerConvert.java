package com.btg.PetSpringApi.utils;

import com.btg.PetSpringApi.controller.dto.CustomerRequest;
import com.btg.PetSpringApi.controller.dto.CustomerResponse;
import com.btg.PetSpringApi.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

public class CustomerConvert {


    public static Customer toEntity(CustomerRequest customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        return customer;
    }

    public static CustomerResponse toResponse(Customer customer){
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(customer.getId());
        customerResponse.setName(customer.getName());
        customerResponse.setPhoneNumber(customer.getPhoneNumber());

        return customerResponse;

    }

    public static List<CustomerResponse> toResponseList(List<Customer> customers) {
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerResponse customerResponse = CustomerConvert.toResponse(customer);
            customerResponses.add(customerResponse);
        }
        return customerResponses;

    }

    public static Page<CustomerResponse> toResponsePage(Page<Customer> customers){
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for (Customer customer : customers){
            CustomerResponse customerResponse = CustomerConvert.toResponse(customer);
            customerResponses.add(customerResponse);
        }
        return new PageImpl<>(customerResponses);
    }
}
