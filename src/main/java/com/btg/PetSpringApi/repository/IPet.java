package com.btg.PetSpringApi.repository;

import com.btg.PetSpringApi.model.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPet extends JpaRepository<Pet, Integer> {
    @Query(value =  "SELECT * FROM PETS WHERE ACTIVE = TRUE", nativeQuery = true)
    Page<Pet> findAllActivePets(Pageable pageable);


    List<Pet> findByBreed (String breed);
    List<Pet> findAllByName (String name);

}