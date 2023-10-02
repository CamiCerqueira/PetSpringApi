package com.btg.PetSpringApi.utils;

import com.btg.PetSpringApi.controller.dto.TypeProductRequest;
import com.btg.PetSpringApi.controller.dto.TypeProductResponse;
import com.btg.PetSpringApi.model.TypeProduct;

import java.util.ArrayList;
import java.util.List;

public class TypeProductConvert {

    public static TypeProduct toEntity(TypeProductRequest typeProductRequest) {
        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setName(typeProductRequest.getName());
        return typeProduct;
    }

    public static TypeProductResponse toResponse(TypeProduct typesProduct) {
        TypeProductResponse typeProductResponse = new TypeProductResponse();
        typeProductResponse.setId(typesProduct.getId());
        typeProductResponse.setName(typesProduct.getName());
        return typeProductResponse;
    }

    public static List<TypeProductResponse> toResponseList(List<TypeProduct> typesProducts) {
        List<TypeProductResponse> typesProductResponses = new ArrayList<>();
        for (TypeProduct typeProduct : typesProducts) {
            typesProductResponses.add(toResponse(typeProduct));
        }

        return typesProductResponses;
    }
}
