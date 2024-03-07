package com.example.businessService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.businessService.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

