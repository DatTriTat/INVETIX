package com.example.userService.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.userService.dto.AuthRequest;
import com.example.userService.model.User;
import com.example.userService.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String saveUser(User user) {
        Optional<User> credential = userRepository.findByUsername(user.getUsername());
        System.out.println(user.getUsername());

        if (credential.isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return "user added to the system";
        }
        return "user already exist";
    }

    public long userId(String username) {
        System.out.println(username);
        Optional<User> credential = userRepository.findByUsername(username);
        System.out.println(credential);
        if (credential.isEmpty()) {
            return -1;
        }
        return credential.get().getId();
    }
    public String generateToken(String userName) {
        return jwtService.generateToken(userName);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }

    public void change(AuthRequest user) {
        Optional<User> credential = userRepository.findByUsername(user.getUsername());
        credential.get().setPassword(passwordEncoder.encode(user.getPassword()));
        
    }

}