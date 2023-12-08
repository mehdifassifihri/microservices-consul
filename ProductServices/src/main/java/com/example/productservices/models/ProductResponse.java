package com.example.productservices.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private int id;

    private String name;
    private double price;

    private CategoryDetails categoryDetails;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CategoryDetails {

        private int id;

        private String name;
    }
}
