package com.example.productservices.services;

import com.example.productservices.entities.Category;
import com.example.productservices.entities.Product;
import com.example.productservices.external.CategoryService;
import com.example.productservices.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServicesImpl implements ProductServices{
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryService categoryService;


    @Override
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            Optional<Category> optionalCategory = categoryService.getCategoryById(product.getCat_Id());
            if (!optionalCategory.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            product.setCategory(optionalCategory.get());
            productRepository.save(product);
        }
        return ResponseEntity.ok(products);
    }


    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }


}
