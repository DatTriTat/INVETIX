package com.example.businessService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.businessService.model.Category;
import com.example.businessService.repository.CategoryRepository;

@Service("CategoryService")
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public void create(String category) {
        Category newCategory = new Category();
        category = category.toUpperCase();
        newCategory.setCategory(category);
        categoryRepository.save(newCategory);
    }

}
