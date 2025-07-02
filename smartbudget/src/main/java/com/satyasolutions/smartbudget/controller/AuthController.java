package com.satyasolutions.smartbudget.controller;

import com.satyasolutions.smartbudget.dto.LoginRequest;
import com.satyasolutions.smartbudget.dto.LoginResponse;
import com.satyasolutions.smartbudget.dto.RegisterRequest;
import com.satyasolutions.smartbudget.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        String token = authService.login(request);
        if (token == null) {
            return ResponseEntity.status(401).build(); // Invalid login
        }
        return ResponseEntity.ok(new LoginResponse(token));
    }

}
