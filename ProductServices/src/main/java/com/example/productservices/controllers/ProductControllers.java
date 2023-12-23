package com.example.productservices.controllers;

import com.example.productservices.dto.CategoryDTO;
import com.example.productservices.entities.Product;
import com.example.productservices.external.CategoryService;
import com.example.productservices.models.ProductResponse;
import com.example.productservices.services.ProductServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductControllers {
    @Autowired
    ProductServicesImpl productServices;
    @Autowired
    CategoryService categoryService;

    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/rest")
    ResponseEntity<List<ProductResponse>> getProducts(){
        return productServices.getProducts();
    }

    @GetMapping("/feign")
    ResponseEntity<List<ProductResponse>> getProductsWithFeign(){
        return productServices.getProductsWithFeign();
    }

    @PostMapping()
    Product addProduct(@RequestBody Product product){
        return productServices.addProduct(product);
    }


    @GetMapping("/hello")
    public String getData() {
        String url = "http://localhost:5001/api/Mehdi"; // Replace with your target URL
        return restTemplate.getForObject(url, String.class);
    }
}
