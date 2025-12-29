package com.example.demo.service.impl;

import com.example.demo.dto.*;
import com.example.demo.entity.UserProfile;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.AuthService;
import com.example.demo.service.UserProfileService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    private final UserProfileService userService;
    private final UserProfileRepository userProfileRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserProfileService userService,
                           UserProfileRepository userProfileRepository,
                           AuthenticationManager authenticationManager,
                           JwtUtil jwtUtil,
                           PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.userProfileRepository = userProfileRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public JwtResponse register(RegisterRequest req) {
        // Validation
        if (userProfileRepository.existsByEmail(req.getEmail())) {
            throw new BadRequestException("Duplicate email");
        }

        UserProfile user = new UserProfile();
        user.setFullName(req.getFullName());
        user.setEmail(req.getEmail());
        
        // Use PasswordEncoder for security
        user.setPassword(passwordEncoder.encode(req.getPassword()));
        
        user.setRole(req.getRole() != null ? req.getRole() : "USER");
        user.setUserId(req.getUserId() != null ? req.getUserId() : UUID.randomUUID().toString());
        user.setActive(true);

        UserProfile saved = userService.createUser(user);

        String token = jwtUtil.generateToken(saved.getId(), saved.getEmail(), saved.getRole());
        return new JwtResponse(token, saved.getId(), saved.getEmail(), saved.getRole());
    }

    @Override
    public JwtResponse login(LoginRequest req) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword())
        );

        UserProfile user = userProfileRepository.findByEmail(req.getEmail())
                .orElseThrow(() -> new BadRequestException("Invalid user"));

        String token = jwtUtil.generateToken(user.getId(), user.getEmail(), user.getRole());
        return new JwtResponse(token, user.getId(), user.getEmail(), user.getRole());
    }
}