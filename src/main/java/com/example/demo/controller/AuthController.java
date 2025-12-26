package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Auth")
public class AuthController {

    private final UserService service;

    public AuthController(UserService service) {
        this.service = service;
    }

    public ResponseEntity<?> register(RegisterRequest request) {
        try {
            return ResponseEntity.ok(service.register(request));
        } catch (Exception e) {
            // 🔥 REQUIRED: return 400 when email exists
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<AuthResponse> login(AuthRequest request) {
        return ResponseEntity.ok(service.login(request));
    }
}
