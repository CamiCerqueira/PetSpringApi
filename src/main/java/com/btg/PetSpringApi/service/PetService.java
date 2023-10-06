package com.btg.PetSpringApi.service;


import com.btg.PetSpringApi.controller.dto.PetRequest;
import com.btg.PetSpringApi.controller.dto.PetResponse;
import com.btg.PetSpringApi.model.Pet;
import com.btg.PetSpringApi.repository.IPet;
import com.btg.PetSpringApi.utils.PetConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    IPet petRepository;

    public Page<PetResponse> getPet(int page, int size, String direction){
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.fromString(direction), "name");
        Page<Pet> pets = petRepository.findAllActivePets(pageRequest);
        return PetConvert.toResponsePage(pets);

    }

    public PetResponse savePet(PetRequest petDTO) {
        Pet pet = PetConvert.toEntity(petDTO);
        pet.setActive(true);
        return PetConvert.toResponse(pet);
    }

    public PetResponse getPetById(Integer id){
        Optional<Pet> petResponse =  petRepository.findById(id);
        if(petResponse.isPresent()){
            return PetConvert.toResponse(petResponse.get());
        } else {
            throw new RuntimeException("nao encontrado");
        }
    }

    public List<PetResponse> getAllByName(String name){
        IPet petRepository = null;
        return PetConvert.toResponseList(petRepository.findAllByName(name));
    }

    public List<PetResponse> getAllByBreed(String breed){
        IPet petRepository = null;
        return PetConvert.toResponseList(petRepository.findByBreed(breed));
    }

    public void deletePet(Integer id){
        Pet pet = petRepository.findById(id).orElseThrow();
        pet.setActive(false);
        petRepository.save(pet);
    }

    public PetResponse updatePet(Integer id, PetRequest petRequest){
        Pet pet = PetConvert.toEntity(petRequest);
        pet.setId(id);
        return PetConvert.toResponse(petRepository.save(pet));
    }
}
