package com.btg.PetSpringApi.service;

import com.btg.PetSpringApi.controller.dto.TypePetServiceRequest;
import com.btg.PetSpringApi.controller.dto.TypePetServiceResponse;
import com.btg.PetSpringApi.model.TypePetService;
import com.btg.PetSpringApi.repository.ITypePetService;
import com.btg.PetSpringApi.utils.TypePetServiceConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypePetServiceService {
    @Autowired
    ITypePetService typePetServiceRepository;

    public List<TypePetServiceResponse> getAllTypePetServices() {
        return TypePetServiceConvert.toResponseList(typePetServiceRepository.findAll());
    }

    public TypePetServiceResponse saveTypePetService(TypePetServiceRequest typePetServiceRequest) {
        TypePetService typePetService = typePetServiceRepository.save(TypePetServiceConvert.toEntity(typePetServiceRequest));
        return TypePetServiceConvert.toResponse(typePetService);
    }

    public void deleteTypePetService(Integer id) {
        typePetServiceRepository.deleteById(id);
    }
}

