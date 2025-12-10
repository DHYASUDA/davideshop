package com.example.davideshop.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.davideshop.dto.productRequest;
import com.example.davideshop.model.productEntity;
import com.example.davideshop.service.productService;

@RestController // tells java that this class is a restcontroller and to look for http requests
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173")
public class productController {
    private final productService productService;

    public productController(productService productService) {
        this.productService = productService;
    }

    @PostMapping("/search-by-id")
    public productEntity searchById(@RequestBody productRequest request) {// this turns react json file to a dto
        return productService.searchById(request);
    }

}
