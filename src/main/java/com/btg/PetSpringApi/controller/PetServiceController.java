package com.btg.PetSpringApi.controller;
import com.btg.PetSpringApi.service.PetServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.btg.PetSpringApi.controller.dto.PetServiceRequest;
import com.btg.PetSpringApi.controller.dto.PetServiceResponse;
import com.btg.PetSpringApi.service.PetServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/petService")
public class PetServiceController {

    @Autowired
    PetServiceService petServiceService;

    @GetMapping
    public ResponseEntity<List<PetServiceResponse>> getAllPetService(
            @RequestParam(name = "typePetService", required = false) Integer typePetService
    ) {
        return ResponseEntity.ok(petServiceService.getAllPetService(typePetService));
    }

    @PostMapping
    public ResponseEntity<PetServiceResponse> savePetService(@RequestBody PetServiceRequest petServiceRequest) {
        PetServiceResponse petServiceResponse = petServiceService.savePetService(petServiceRequest);
        return ResponseEntity.created(URI.create("/petService/"+petServiceResponse.getId())).body(petServiceResponse);
    }
}
