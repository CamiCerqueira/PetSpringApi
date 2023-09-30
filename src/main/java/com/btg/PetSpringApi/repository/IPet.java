package com.btg.PetSpringApi.repository;

import com.btg.PetSpringApi.model.Customer;
import com.btg.PetSpringApi.model.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IPet extends JpaRepository<Pet, Integer> {
    @Override
    @Query(value =  "SELECT * FROM PETS WHERE ACTIVE = TRUE", nativeQuery = true)
    Page<Pet> findAll(Pageable pageable);

    //Tem que fazer outro query?
    // Optional<Customer> findAllByName (String name);

    Optional<Pet> findAllByName (String name);
    Optional<Pet> findAllByBreed (String breed);
    List<Pet> findAllByName (String name);

}
