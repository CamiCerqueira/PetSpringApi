package com.btg.PetSpringApi.controller;

<<<<<<< HEAD
import com.btg.PetSpringApi.controller.dto.ProductRequest;
import com.btg.PetSpringApi.controller.dto.ProductResponse;
import com.btg.PetSpringApi.model.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
=======
import com.btg.PetSpringApi.controller.dto.PetServiceRequest;
import com.btg.PetSpringApi.controller.dto.PetServiceResponse;
import com.btg.PetSpringApi.model.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
>>>>>>> origin/master

import java.net.URI;
import java.util.List;

<<<<<<< HEAD
@RestController
@RequestMapping
public class PetServiceController {
=======

public class PetServiceController {


>>>>>>> origin/master
    @Autowired
    PetService petService;

    @GetMapping
<<<<<<< HEAD
    public ResponseEntity<List<ProductResponse>> getAllProduct(
            @RequestParam(name = "typeProduct", required = false) Integer typeProduct
    ){
        return ResponseEntity.ok(petService.getAllProduct(typeProduct));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> saveProduct(@RequestBody ProductRequest productRequest){
        ProductResponse productResponse =  petService.savePetService (productRequest);

        return ResponseEntity.created(URI.create("/product/"+productResponse.getId())).body(productResponse);
    }
=======
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

>>>>>>> origin/master
}
