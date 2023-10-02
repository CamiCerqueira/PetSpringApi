package com.btg.PetSpringApi.utils;

import com.btg.PetSpringApi.controller.dto.TypePetServiceRequest;
import com.btg.PetSpringApi.controller.dto.TypePetServiceResponse;
import com.btg.PetSpringApi.model.TypePetService;

import java.util.ArrayList;
import java.util.List;

public class TypePetServiceConvert {

    public static TypePetService toEntity(TypePetServiceRequest typePetServiceRequest) {
        TypePetService typePetService = new TypePetService();
        typePetService.setName(typePetServiceRequest.getName());
        return typePetService;
    }

    public static TypePetServiceResponse toResponse (TypePetService typePetService) {
        TypePetServiceResponse typePetServiceResponse = new TypePetServiceResponse();
        typePetServiceResponse.setId(typePetServiceResponse.getId());
        typePetServiceResponse.setName(typePetServiceResponse.getName());
        return typePetServiceResponse;
    }

    public static List<TypePetServiceResponse> toResponseList (List<TypePetService> typesPetServices){
       List<TypePetServiceResponse> typePetServiceResponses =  new ArrayList<>();
       for(TypePetService typePetService : typesPetServices) {
           typePetServiceResponses.add(toResponse(typePetService));
       }
       return typePetServiceResponses;

       }
    }