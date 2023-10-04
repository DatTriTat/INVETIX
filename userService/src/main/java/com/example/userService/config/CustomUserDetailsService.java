package com.example.userService.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.example.userService.model.User;
import com.example.userService.repository.UserRepository;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> credential = userRepository.findByUserName(userName);
        if (!credential.isEmpty()) {
            return new CustomUserDetails(credential.get());
        } else {
            System.out.println("User not found: " + userName);
            throw new UsernameNotFoundException("User not found: " + userName);
        }
    }
}