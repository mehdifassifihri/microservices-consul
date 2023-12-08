package com.example.productservices.services;

import com.example.productservices.entities.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductServices {
    ResponseEntity<List<Product>> getProducts();
    Product addProduct(Product product);
}
