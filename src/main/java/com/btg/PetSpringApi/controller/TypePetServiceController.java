package com.btg.PetSpringApi.controller;

import com.btg.PetSpringApi.controller.dto.TypePetServiceRequest;
import com.btg.PetSpringApi.controller.dto.TypePetServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("type-pet-service")

public class TypePetServiceController {
    @Autowired
    TypePetServiceService typePetServiceService;  // Corrija para o serviço apropriado

    @GetMapping
    public ResponseEntity<List<TypePetServiceResponse>> getAllTypePetService() {
        return ResponseEntity.ok(typePetServiceService.getAllTypePetService());
    }

    @PostMapping
    public ResponseEntity<TypePetServiceResponse> saveTypePetService(@RequestBody TypePetServiceRequest typePetServiceRequest) {
        TypePetServiceResponse typePetServiceResponse = typePetServiceService.saveTypePetService(typePetServiceRequest);
        return ResponseEntity.created(URI.create("/type-pet-service/" + typePetServiceResponse.getId())).body(typePetServiceResponse);
    }

    @DeleteMapping("/{id}")
    public void deleteTypePetService(@PathVariable Integer id) {
        typePetServiceService.deleteTypePetService(id);
    }
}
