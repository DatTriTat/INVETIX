package com.example.userService.controller;

import com.example.userService.dto.AuthRequest;
import com.example.userService.model.User;
import com.example.userService.service.AuthService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class AuthController {
    @Autowired
    private AuthService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String addNewUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @PostMapping("/login")
    public String getToken(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return service.generateToken(authRequest.getUsername());
        } else {
            throw new RuntimeException("invalid access");
        }
    }
    
    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        System.out.println(token);
        service.validateToken(token);
        return "Token is valid";
    }

    @PostMapping("/userId")
    public long getUserId(@RequestBody Map<String, String> userRequest) {
        return service.userId(userRequest.get("username").toString());
    }
}