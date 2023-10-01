package com.btg.PetSpringApi.repository;

import com.btg.PetSpringApi.model.PetService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPetService extends JpaRepository <PetService, Integer> {

    //Como criamos a TypePetService criei a query para buscar por Type.
    @Query("SELECT p FROM Product p WHERE p.type.id = :type")
    List<PetService> findProductByType(@Param("type") Integer typePetService);

}
