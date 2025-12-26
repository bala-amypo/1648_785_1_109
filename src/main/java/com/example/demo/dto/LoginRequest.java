package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        
        // 1. Extract data from your DTO
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        // 2. Dummy validation logic 
        // (In a real app, you would use a Service to check your Database)
        if ("Naveen@gmail.com".equals(email) && "Naveen@cr7".equals(password)) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                 .body("Invalid email or password");
        }
    }
}