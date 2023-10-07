package com.btg.PetSpringApi.repository;

import com.btg.PetSpringApi.model.PetService;
import com.btg.PetSpringApi.model.TypePetService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Type;

public interface ITypePetService extends JpaRepository<TypePetService, Integer> {
}
