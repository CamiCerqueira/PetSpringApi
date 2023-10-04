package com.btg.PetSpringApi.utils;

import com.btg.PetSpringApi.controller.dto.PetServiceRequest;
import com.btg.PetSpringApi.controller.dto.PetServiceResponse;
import com.btg.PetSpringApi.model.PetService;
import com.btg.PetSpringApi.model.TypePetService;

import java.util.ArrayList;
import java.util.List;

public class PetServiceConvert {
    public static PetService toEntity(PetServiceRequest petServiceRequest, TypePetService typePetService) {
        PetService petService = new PetService();
        petService.setName(petServiceRequest.getName());
        petService.setPrice(petServiceRequest.getPrice());
        petService.setType(typePetService);
        return petService;

    }


    public static PetServiceResponse toResponse(PetService petService) {
        PetServiceResponse petServiceResponse = new PetServiceResponse();
        petServiceResponse.setId(petService.getId());
        petServiceResponse.setName(petService.getName());
        petServiceResponse.setPrice(petService.getPrice());
        petServiceResponse.setType(petService.getType()); //typePetServiceConvert não atribuiu
        return petServiceResponse;
    }


    public static List<PetServiceResponse> toResponseList(List<PetService> petsServices) {
        List<PetServiceResponse> petServiceResponses = new ArrayList<>();
        for (PetService petService : petsServices) {
            petServiceResponses.add(toResponse(petService));

        }
        return petServiceResponses;
    }
}
