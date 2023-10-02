package com.btg.PetSpringApi.controller;

import com.btg.PetSpringApi.controller.dto.TypePetServiceRequest;
import com.btg.PetSpringApi.controller.dto.TypePetServiceResponse;
import com.btg.PetSpringApi.controller.dto.TypeProductResponse;
import com.btg.PetSpringApi.model.TypePetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping

public class TypePetServiceController {
    @Autowired
    TypePetService typePetService;

    @GetMapping
    public ResponseEntity<List<TypePetServiceResponse>> getAllTypeProduct(){
        return ResponseEntity.ok(typePetService.getAllTypePetService());
    }

    @PostMapping
    public ResponseEntity<TypePetServiceResponse> saveTypeProduct(@RequestBody TypePetServiceRequest typePetServiceRequest){
        TypePetServiceResponse typeProductResponse = typePetService.saveTypePetService (typePetServiceRequest);
        return ResponseEntity.created(URI.create("/type-product/"+typePetServiceResponse.getId())).body(typePetServiceResponse);
    }

    @DeleteMapping("/{id}")
    public void deleteTypePetService(@PathVariable Integer id){
        typePetService.deleteTypePetService (id);
    }
}
