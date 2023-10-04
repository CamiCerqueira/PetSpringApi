package com.btg.PetSpringApi.repository;

import com.btg.PetSpringApi.model.PetService;
import com.btg.PetSpringApi.model.TypePetService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypePetService extends JpaRepository<TypePetService, Integer> {
}
