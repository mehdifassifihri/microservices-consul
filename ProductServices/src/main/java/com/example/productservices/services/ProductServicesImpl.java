package com.example.productservices.services;

import com.example.productservices.dto.CategoryDTO;
import com.example.productservices.entities.Product;
import com.example.productservices.external.CategoryService;
import com.example.productservices.models.ProductResponse;
import com.example.productservices.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServicesImpl implements ProductServices{
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryService categoryService;
    @Autowired
    RestTemplate restTemplate;


    @Override
    public ResponseEntity<List<ProductResponse>> getProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponse> productResponses = new ArrayList<>();

        for (Product product : products) {

            ProductResponse productResponse = new ProductResponse();


            productResponse.setId(product.getId());
            productResponse.setName(product.getName());
            productResponse.setPrice(product.getPrice());

            CategoryDTO test = restTemplate.getForObject("http://CATEGORY-SERVICES/category/"+product.getCat_Id(), CategoryDTO.class);


            ProductResponse.CategoryDetails categoryDetails = new ProductResponse.CategoryDetails(test.getId(), test.getName());
            productResponse.setCategoryDetails(categoryDetails);

            productResponses.add(productResponse);
        }

        return ResponseEntity.ok(productResponses);
    }


    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }


}
