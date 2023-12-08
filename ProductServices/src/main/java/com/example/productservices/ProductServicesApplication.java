package com.example.productservices;

import com.example.productservices.entities.Category;
import com.example.productservices.entities.Product;
import com.example.productservices.external.CategoryService;
import com.example.productservices.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ProductServicesApplication {



    public static void main(String[] args) {
        SpringApplication.run(ProductServicesApplication.class, args);
    }

}
