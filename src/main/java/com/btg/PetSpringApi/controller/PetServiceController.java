package com.btg.PetSpringApi.controller;

import com.btg.PetSpringApi.controller.dto.PetServiceRequest;
import com.btg.PetSpringApi.controller.dto.PetServiceResponse;
import com.btg.PetSpringApi.model.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;
import java.util.List;


public class PetServiceController {


    @Autowired
    PetService petService;

    @GetMapping
    public ResponseEntity<List<PetService>> getAllPetService(
            @RequestParam(name = "typePetService", required = false) Integer typePetService
    ){
        return ResponseEntity.ok(petService.getAllProduct(typePetService));
    }

    @PostMapping
    public ResponseEntity<PetServiceResponse> savePetService(@RequestBody PetServiceRequest petServiceRequest){
        PetServiceRequest petServiceRequest1 = petServiceRequest.savePetService(petServiceRequest);

        return ResponseEntity.created(URI.create("/petservice/"+petServiceResponse.getId())).body(petServiceResponse);
    }

}
