package com.example.productservices.controllers;

import com.example.productservices.entities.Product;
import com.example.productservices.external.CategoryService;
import com.example.productservices.models.ProductResponse;
import com.example.productservices.services.ProductServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductControllers {
    @Autowired
    ProductServicesImpl productServices;
    @Autowired
    CategoryService categoryService;
    @GetMapping()
    ResponseEntity<List<ProductResponse>> getProducts(){
        return productServices.getProducts();
    }
    @PostMapping()
    Product addProduct(@RequestBody Product product){
        return productServices.addProduct(product);
    }

}
