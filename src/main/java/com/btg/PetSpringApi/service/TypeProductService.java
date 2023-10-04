package com.btg.PetSpringApi.service;

import com.btg.PetSpringApi.controller.dto.TypeProductRequest;
import com.btg.PetSpringApi.controller.dto.TypeProductResponse;
import com.btg.PetSpringApi.model.TypeProduct;
import com.btg.PetSpringApi.repository.ITypeProduct;
import com.btg.PetSpringApi.utils.TypeProductConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeProductService {

    @Autowired
    ITypeProduct typeProductRepository;

    public List<TypeProductResponse> getAllTypeProducts(){
        return TypeProductConvert.toResponseList(typeProductRepository.findAll());
    }

    public TypeProductResponse saveTypeProduct(TypeProductRequest typeProductRequest){
        TypeProduct typeProduct = typeProductRepository.save(
                TypeProductConvert.toEntity(typeProductRequest)
        );
        return TypeProductConvert.toResponse(typeProduct);
    }

    public void deleteTypeProduct(Integer id){
        typeProductRepository.deleteById(id);
    }
}
