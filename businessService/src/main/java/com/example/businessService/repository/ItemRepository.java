package com.example.businessService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.businessService.model.Item;


public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByName (String name);
    Optional<Item> findByNameAndLocation(String name, String location);

}

