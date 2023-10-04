package com.btg.PetSpringApi.service;

import com.btg.PetSpringApi.controller.dto.PetServiceRequest;
import com.btg.PetSpringApi.controller.dto.PetServiceResponse;
import com.btg.PetSpringApi.model.PetService;
import com.btg.PetSpringApi.model.TypePetService;
import com.btg.PetSpringApi.repository.IPetService;
import com.btg.PetSpringApi.repository.ITypePetService;
import com.btg.PetSpringApi.utils.PetServiceConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PetServiceService {
    @Autowired
    IPetService petServiceRepository;

    @Autowired
    ITypePetService typePetServiceRepository;

    public PetServiceResponse savePetService(PetServiceRequest petServiceRequest) {
        TypePetService typePetService = typePetServiceRepository.findById(petServiceRequest.getTypeId()).get().getType();
        PetService petService = PetServiceConvert.toEntity(petServiceRequest, typePetService);
        return PetServiceConvert.toResponse(petServiceRepository.save(petService));
    }
    public List<PetServiceResponse> getAllPetService(Integer typePetService) {
        if (typePetService != null) {
            return getAllByTypePetService(typePetService);
        }
        return PetServiceConvert.toResponseList(petServiceRepository.findAll());
    }

    public List<PetServiceResponse> getAllByTypePetService(Integer typePetService) {
        return PetServiceConvert.toResponseList(petServiceRepository.findPetServiceByType(typePetService));
    }

}
