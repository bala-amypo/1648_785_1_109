package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;

public class AuthController {

    private final UserProfileService service;
    private final UserProfileRepository repo;
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    public AuthController(UserProfileService s, UserProfileRepository r,
                          AuthenticationManager a, JwtUtil j) {
        this.service = s;
        this.repo = r;
        this.authManager = a;
        this.jwtUtil = j;
    }

    public ResponseEntity<JwtResponse> register(RegisterRequest req) {
        UserProfile u = new UserProfile();
        u.setFullName(req.getFullName());
        u.setEmail(req.getEmail());
        u.setPassword(req.getPassword());
        u.setRole(req.getRole());

        UserProfile saved = service.createUser(u);

        String token = jwtUtil.generateToken(saved.getId(), saved.getEmail(), saved.getRole());
        return ResponseEntity.ok(new JwtResponse(saved.getId(), saved.getEmail(), token));
    }

    public ResponseEntity<JwtResponse> login(LoginRequest req) {
        UserProfile u = repo.findByEmail(req.getEmail()).orElseThrow();

        String token = jwtUtil.generateToken(u.getId(), u.getEmail(), u.getRole());
        return ResponseEntity.ok(new JwtResponse(u.getId(), u.getEmail(), token));
    }
}
