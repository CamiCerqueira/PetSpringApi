package com.btg.PetSpringApi.repository;

import com.btg.PetSpringApi.model.PetService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypePetService extends JpaRepository<PetService, Integer> {
}
