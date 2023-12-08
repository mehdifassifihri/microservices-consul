package com.example.productservices.external;

import com.example.productservices.dto.CategoryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "CATEGORY-SERVICES/category")
public interface CategoryService {
    @GetMapping("/{id}")
    Optional<CategoryDTO> getCategoryById(@PathVariable int id);

}
