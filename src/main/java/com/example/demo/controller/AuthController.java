package com.example.demo.controller;

import com.example.demo.entity.ExtraStudent;
import com.example.demo.repository.ExtraStudentRepository;
import com.example.demo.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*") 
public class AuthController {

    @Autowired private AuthenticationManager authManager;
    @Autowired private ExtraStudentRepository repo;
    @Autowired private PasswordEncoder encoder;
    @Autowired private JwtUtil jwtUtil;

    @PostMapping("/add")
    public String register(@RequestBody ExtraStudent student) {
        student.setPassword(encoder.encode(student.getPassword()));
        repo.save(student);
        return "Student Registered Successfully";
    }
    @PostMapping("/login")
public ResponseEntity<?> login(@RequestBody AuthRequest request) {
    // 1. Find the student in the database
    ExtraStudent student = repo.findByEmail(request.getEmail())
            .orElseThrow(() -> new RuntimeException("User not found"));

    // 2. Authenticate the user
    authManager.authenticate(new UsernamePasswordAuthenticationToken(
            request.getEmail(), request.getPassword()));

    // 3. FIX: Pass all 3 required arguments to generateToken
    // Format: generateToken(Long id, String email, String role)
    String token = jwtUtil.generateToken(
            student.getId(), 
            student.getEmail(), 
            student.getRole()
    );

    // 4. Return the response
    return ResponseEntity.ok(new AuthResponse(token, student.getRole()));
}
}