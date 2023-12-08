package com.example.productservices.services;

import com.example.productservices.entities.Product;
import com.example.productservices.models.ProductResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductServices {
    ResponseEntity<List<ProductResponse>> getProducts();
    Product addProduct(Product product);
}
