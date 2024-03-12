package com.example.businessService.model;

import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;
 
@Entity
@Table(name = "Items")
@Data
@RequiredArgsConstructor
public class Item {
    
    private @Id @GeneratedValue @JsonIgnore Long id;

    @NotNull(message = "Name cannot be empty")
    @Column(name = "Name")
    private String name;

    @NotNull(message = "category cannot be empty")
    @Column(name = "category")
    private Category category;

    @Column(name = "desciption")
    private String desciption;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "expired_Date")
    private LocalDateTime expired;
    
    @Column(name = "location")
    private String location;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
