package com.btg.PetSpringApi.repository;

import com.btg.PetSpringApi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProduct extends JpaRepository<Product, Integer> {

    //Como criamos a TypeProduct criei a query para buscar por Type.
    @Query("SELECT p FROM Product p WHERE p.type.id = :type")
    List<Product> findProductByType(@Param("type") Integer typeProduct);
}
