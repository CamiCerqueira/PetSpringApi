package com.btg.PetSpringApi.controller;

import com.btg.PetSpringApi.controller.dto.UserEmployeeRequest;
import com.btg.PetSpringApi.controller.dto.UserEmployeeResponse;
import com.btg.PetSpringApi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping ("/user")
public class UserEmployeeController {
    @Autowired
    CustomerService userEmployeeService;
    @RequestMapping
    public ResponseEntity <Page<UserEmployeeResponse>> getUsers(
            @RequestParam(value = "page",
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
            ) String direction)
    {return ResponseEntity.ok(userEmployeeService.GetUserEmployeeService;
            UserEmployeeResponse user =  userEmployeeService.saveUserEmployeeService (userDTO);
            return ResponseEntity.created(URI.create("/user/"+user.getId())).body(user);
        }

        @GetMapping("/{id}")
        public ResponseEntity<UserEmployeeResponse> getUser(@PathVariable Integer id){
            return ResponseEntity.ok(userEmployeeService.GetUserEmployeeService.ByResponse(id));
        }

        @GetMapping("/email/{email}")
        public ResponseEntity<UserEmployeeResponse> getUserByEmail(@PathVariable String email){
            return  ResponseEntity.ok(userEmployeeService.GetUserByEmail(email));
        }

        @GetMapping("/name/{name}")
        public ResponseEntity<List<UserEmployeeResponse>> getAllUserByName(@PathVariable String name, @PathVariable Integer id){
            return ResponseEntity.ok(userEmployeeService.getAllByName (name));
        }

        @DeleteMapping("/{id}")
        public void deleteUser(@PathVariable Integer id){
            userEmployeeService.deleteUser(id);
        }

        @PutMapping("/{id}")
        public ResponseEntity<UserEmployeeResponse> updateUser(
                @PathVariable Integer id,
                @RequestBody UserEmployeeRequest userRequest
    ){
            return  ResponseEntity.ok(userEmployeeService.updateUser(id, userRequest));

}