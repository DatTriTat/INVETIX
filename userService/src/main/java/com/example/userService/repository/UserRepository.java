package com.example.userService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userService.model.User;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);
    Optional<User> findByUsernameAndPassword(String userName, String password);
}