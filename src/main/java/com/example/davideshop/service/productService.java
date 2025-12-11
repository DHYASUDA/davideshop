package com.example.davideshop.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.davideshop.dto.productRequest;
import com.example.davideshop.model.productEntity;
import com.example.davideshop.repository.productRepo;

@Service
public class productService {
    private final productRepo productRepo;

    public productService(productRepo productRepo) {
        this.productRepo = productRepo;
    }

    // create product
    
    public productEntity createProduct(productRequest request) {
        productEntity product = new productEntity();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStockQuantity(request.getStockQuantity());
        product.setCategory(request.getCategory());
        product.setImageUrl(request.getImageUrl());
        return productRepo.save(product); 
    }
    // search product by id
    public productEntity searchById(productRequest request) {
        Optional<productEntity> optionalProduct = productRepo.findById(request.getId());

        if (optionalProduct.isEmpty()) {
            throw new IllegalArgumentException("Unable to find product");
        }
        productEntity product = optionalProduct.get();
        return product;

    }
}
