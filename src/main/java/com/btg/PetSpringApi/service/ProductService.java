package com.btg.PetSpringApi.service;

import com.btg.PetSpringApi.controller.dto.ProductRequest;
import com.btg.PetSpringApi.controller.dto.ProductResponse;
import com.btg.PetSpringApi.model.Product;
import com.btg.PetSpringApi.model.TypeProduct;
import com.btg.PetSpringApi.repository.IProduct;
import com.btg.PetSpringApi.repository.ITypeProduct;
import com.btg.PetSpringApi.utils.ProductConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    IProduct productRepository;

    @Autowired
    ITypeProduct typeProductRepository;

    public ProductResponse saveProduct(ProductRequest productRequest){
        TypeProduct typeProduct = typeProductRepository.findById(productRequest.getTypeId()).get();
        Product product = ProductConvert.toEntity(productRequest, typeProduct);
        return  ProductConvert.toResponse(productRepository.save(product));
    }

    public List<ProductResponse> getAllProduct(Integer typeProduct){
        if(typeProduct != null){
            return getAllByTypeProduct(typeProduct);
        }
        return ProductConvert.toResponseList(productRepository.findAll());
    }

    public List<ProductResponse> getAllByTypeProduct(Integer typeProduct) {
        return ProductConvert.toResponseList(productRepository.findProductByType(typeProduct));

    }
}
