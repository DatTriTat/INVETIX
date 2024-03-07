package com.example.businessService.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.businessService.model.Category;
import com.example.businessService.repository.CategoryRepository;


@RestController
@RequestMapping("/category") 
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/create")
    public void create(@RequestHeader("LoggedInUser") String name, @RequestBody Map<String, String> requestBody) {
        String category = requestBody.get("category");
        Category newCategory = new Category();
        category = category.toUpperCase();
        newCategory.setCategory(category);
        categoryRepository.save(newCategory);
        System.out.println("Sucessfully");
    }

}
