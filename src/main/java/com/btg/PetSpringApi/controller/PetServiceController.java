package com.btg.PetSpringApi.controller;

import com.btg.PetSpringApi.controller.dto.ProductRequest;
import com.btg.PetSpringApi.controller.dto.ProductResponse;
import com.btg.PetSpringApi.model.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping
public class PetServiceController {
    @Autowired
    PetService petService;

    @GetMapping
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
}
