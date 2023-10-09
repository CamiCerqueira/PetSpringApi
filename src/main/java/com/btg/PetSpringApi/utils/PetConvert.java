package com.btg.PetSpringApi.utils;


import com.btg.PetSpringApi.controller.dto.PetRequest;
import com.btg.PetSpringApi.controller.dto.PetResponse;
import com.btg.PetSpringApi.model.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

public class PetConvert {


//    public static Pet toEntity(PetRequest petRequest) {
//        Pet pet = new Pet();
//        pet.setName(petRequest.getName());
//        pet.setBreed(petRequest.getBreed());
//        pet.setAge(petRequest.getAge());
//        pet.setWeight(petRequest.getWeight());
//        return pet;
//    }
public static Pet toEntity(PetRequest petDTO) {
    Pet pet = new Pet();
    pet.setName(petDTO.getName());
    pet.setBreed(petDTO.getBreed());
    pet.setAge(petDTO.getAge());
    pet.setWeight(petDTO.getWeight());

    return pet;
}

    public static PetResponse toResponse(Pet pet){
        PetResponse petResponse = new PetResponse();
        petResponse.setId(pet.getId());
        petResponse.setName(pet.getName());
        petResponse.setBreed(pet.getBreed());
        petResponse.setAge(pet.getAge());
        petResponse.setWeight(pet.getWeight());
        return petResponse;

    }

    public static List<PetResponse> toResponseList(List<Pet> pets) {
        List<PetResponse> petResponses = new ArrayList<>();
        for (Pet pet : pets) {
            PetResponse petResponse = PetConvert.toResponse(pet);
            petResponses.add(petResponse);
        }
        return petResponses;

    }

    public static Page<PetResponse> toResponsePage(Page<Pet> pets){
        List<PetResponse> petResponses = new ArrayList<>();
        for (Pet pet : pets){
            PetResponse petResponse = PetConvert.toResponse(pet);
            petResponses.add(petResponse);
        }
        return new PageImpl<>(petResponses);
    }
}


