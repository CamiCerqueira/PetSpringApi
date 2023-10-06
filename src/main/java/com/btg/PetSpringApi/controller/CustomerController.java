package com.btg.PetSpringApi.controller;

import com.btg.PetSpringApi.controller.dto.CustomerRequest;
import com.btg.PetSpringApi.controller.dto.CustomerResponse;
import com.btg.PetSpringApi.controller.exception.PasswordValidationError;
import com.btg.PetSpringApi.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping
    public ResponseEntity<Page<CustomerResponse>> getCustomer(
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0"
            ) int page,
            @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = "10"
            ) int size,
            @RequestParam(
                    value = "direction",
                    required = false,
                    defaultValue = "ASC"
            ) String direction

    ){

        return ResponseEntity.ok(customerService.getCustomer(page, size, direction));
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> saveCustomer(
            @Valid @RequestBody CustomerRequest customerDTO
    ) throws PasswordValidationError {
        CustomerResponse customer =  customerService.saveCustomer(customerDTO);
        return ResponseEntity.created(URI.create("/customer/"+customer.getId())).body(customer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable Integer id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @GetMapping("/phoneNumber/{phoneNumber}")
    public ResponseEntity<CustomerResponse> getCustomerByPhoneNumber(@PathVariable String phoneNumber){
        return  ResponseEntity.ok(customerService.getCustomerByPhoneNumber(phoneNumber));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<CustomerResponse>> getAllCustomerByName(@PathVariable String name, @PathVariable Integer id){
        return ResponseEntity.ok(customerService.getAllByName(name));
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> updateCustomer(
            @PathVariable Integer id,
            @RequestBody CustomerRequest customerRequest
    ){
        return  ResponseEntity.ok(customerService.updateCustomer(id, customerRequest));
    }


}
