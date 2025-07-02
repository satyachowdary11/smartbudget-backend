package com.satyasolutions.smartbudget.service;

import com.satyasolutions.smartbudget.config.JwtService;
import com.satyasolutions.smartbudget.dto.LoginRequest;
import com.satyasolutions.smartbudget.dto.RegisterRequest;
import com.satyasolutions.smartbudget.entity.User;
import com.satyasolutions.smartbudget.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private JwtService jwtService;

    // Register user
    public String register(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            return "Username already exists!";
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);

        return "User registered successfully!";
    }

    // Login check (JWT token logic will come later)
    public String login(LoginRequest request) {
        Optional<User> userOpt = userRepository.findByUsername(request.getUsername());

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                // ✅ Generate JWT token
                String token = jwtService.generateToken(user.getUsername());
                return token;
            }
        }
        return "Invalid username or password";
    }
}
