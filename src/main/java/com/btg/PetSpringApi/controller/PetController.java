package com.btg.PetSpringApi.controller;

import com.btg.PetSpringApi.controller.dto.CustomerRequest;
import com.btg.PetSpringApi.controller.dto.CustomerResponse;
import com.btg.PetSpringApi.controller.dto.PetRequest;
import com.btg.PetSpringApi.controller.dto.PetResponse;
import com.btg.PetSpringApi.controller.exception.PasswordValidationError;
import com.btg.PetSpringApi.service.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    PetService petService;

    @RequestMapping
    public ResponseEntity<Page<PetResponse>> getPet(
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

    ) {

        return ResponseEntity.ok(petService.getPet(page, size, direction));
    }

    @PostMapping
   public ResponseEntity<PetResponse> savePet(@RequestBody PetRequest petRequest){
        PetResponse petResponse = petService.savePet(petRequest);
        return ResponseEntity.created(URI.create("/pet/"+petResponse.getId())).body(petResponse);
    }


    @GetMapping("/{id}")
    public ResponseEntity<PetResponse> getPet(@PathVariable Integer id) {
        return ResponseEntity.ok(petService.getPetById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<PetResponse>> getAllPetByName(@PathVariable String name, @PathVariable Integer id) {
        return ResponseEntity.ok(petService.getAllByName(name));
    }
    @GetMapping("/breed/{breed}")
    public ResponseEntity<List<PetResponse>> getAllPetByBreed(@PathVariable String breed, @PathVariable Integer id) {
        return ResponseEntity.ok(petService.getAllByBreed(breed));
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable Integer id) {
        petService.deletePet(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetResponse> updatePet(
            @PathVariable Integer id,
            @RequestBody PetRequest petRequest
    ) {
        return ResponseEntity.ok(petService.updatePet(id, petRequest));
    }
}


