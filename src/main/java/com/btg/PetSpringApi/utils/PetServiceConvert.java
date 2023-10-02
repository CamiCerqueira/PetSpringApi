package com.btg.PetSpringApi.utils;

import com.btg.PetSpringApi.controller.dto.PetServiceResponse;
import com.btg.PetSpringApi.model.PetService;
import com.btg.PetSpringApi.model.TypePetService;


import java.util.ArrayList;
import java.util.List;


public class PetServiceConvert {
    public static PetServiceConvert toEntity(PetService petService, TypePetService typePetService){
        PetService petService1 = new PetService();
        petService1.setName(petService1.getName());
        petService1.setPrice(petService1.getPrice());
        petService1.setType(typePetService);
        return petService1;

    }

    public static PetServiceResponse toResponse(PetService petService){
        PetServiceResponse petServiceResponse = new PetServiceResponse();
        petServiceResponse.setId(petService.getId());
        petServiceResponse.setName(petService.getName());
        petServiceResponse.getPrice(petService.getPrice());
        petServiceResponse.setType(TypePetServiceConvert.toResponse(petService.getType()));
        return petService;

    }

    public static List<PetServiceResponse> toResponseList(List<PetService> petsServices){
    List<PetServiceResponse> petServiceResponses = new ArrayList<>();
    for (PetService petService : petsServices){
        petServiceResponses.add(toResponse(petService));
     return PetServiceResponse;

    }

}
