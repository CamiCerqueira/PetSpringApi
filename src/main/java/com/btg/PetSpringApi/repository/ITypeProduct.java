package com.btg.PetSpringApi.repository;

import com.btg.PetSpringApi.model.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeProduct extends JpaRepository<TypeProduct,String> {
}
