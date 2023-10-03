package com.btg.PetSpringApi.controller;

import com.btg.PetSpringApi.controller.dto.UserEmployeeRequest;
import com.btg.PetSpringApi.controller.dto.UserEmployeeResponse;
import com.btg.PetSpringApi.controller.exception.PasswordValidationError;
import com.btg.PetSpringApi.service.UserEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/userEmployee")
public class UserEmployeeController {

    @Autowired
    UserEmployeeService userEmployeeService;

    @GetMapping
    public ResponseEntity<Page<UserEmployeeResponse>> getUserEmployees(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size,
            @RequestParam(value = "direction", required = false, defaultValue = "ASC") String direction) {
        return ResponseEntity.ok(userEmployeeService.getUserEmployee(page, size, direction));
    }

    @PostMapping
    public ResponseEntity<UserEmployeeResponse> saveUserEmployee(@RequestBody UserEmployeeRequest userEmployeeDTO)
            throws PasswordValidationError {
        UserEmployeeResponse userEmployee = userEmployeeService.saveUserEmployee(userEmployeeDTO);
        return ResponseEntity.created(URI.create("/userEmployee/" + userEmployee.getId())).body(userEmployee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEmployeeResponse> getUserEmployee(@PathVariable Integer id) {
        return ResponseEntity.ok(userEmployeeService.getUserEmployeeById(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserEmployeeResponse> getUserEmployeeByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userEmployeeService.getUserEmployeeByEmail(email));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<UserEmployeeResponse>> getAllUserEmployeeByName(@PathVariable String name) {
        return ResponseEntity.ok(userEmployeeService.getAllUserEmployeeByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserEmployee(@PathVariable Integer id) {
        userEmployeeService.deleteUserEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEmployeeResponse> updateUserEmployee(
            @PathVariable Integer id,
            @RequestBody UserEmployeeRequest userEmployeeRequest
    ) {
        UserEmployeeResponse updatedUserEmployee = userEmployeeService.updateUserEmployee(id, userEmployeeRequest);
        return ResponseEntity.ok(updatedUserEmployee);
    }
}
