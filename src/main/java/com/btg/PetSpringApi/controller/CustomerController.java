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
@RequestMapping
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping
    public ResponseEntity<Page<CustomerResponse>> getUsers(
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

        return ResponseEntity.ok(customerService.getUsers(page, size, direction));
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> saveUser(
            @Valid @RequestBody CustomerRequest userDTO
    ) throws PasswordValidationError {
        CustomerResponse user =  customerService.saveUser(userDTO);
        return ResponseEntity.created(URI.create("/user/"+user.getId())).body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getUser(@PathVariable Integer id){
        return ResponseEntity.ok(customerService.getUserById(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<CustomerResponse> getUserByEmail(@PathVariable String email){
        return  ResponseEntity.ok(customerService.getUserByEmail(email));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<CustomerResponse>> getAllUserByName(@PathVariable String name, @PathVariable Integer id){
        return ResponseEntity.ok(customerService.getAllByName(name));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        customerService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> updateUser(
            @PathVariable Integer id,
            @RequestBody CustomerRequest userRequest
    ){
        return  ResponseEntity.ok(customerService.updateUser(id, userRequest));
    }


}
