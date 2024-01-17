package com.example.userService.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "USERS")
@Data
@RequiredArgsConstructor
public class User {

    private @Id @GeneratedValue @JsonIgnore Long id;

    @NotNull(message = "Username cannot be empty")
    @Column(name = "username")
    private String username;

    @NotNull(message = "Password cannot be empty")
    @Column(name = "password")
    private String password;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}