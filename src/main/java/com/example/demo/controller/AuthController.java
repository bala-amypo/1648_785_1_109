package com.example.demo.controller;

import com.example.demo.entity.ExtraStudent;
import com.example.demo.repository.ExtraStudentRepo;
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
    @Autowired private ExtraStudentRepo repo;
    @Autowired private PasswordEncoder encoder;
    @Autowired private JwtUtil jwtUtil;

    @PostMapping("/add")
    public String register(@RequestBody ExtraStudent student) {
        student.setPassword(encoder.encode(student.getPassword()));
        repo.save(student);
        return "Student Registered Successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> loginData) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginData.get("email"), loginData.get("password")));
        
        return jwtUtil.generateToken(loginData.get("email"));
    }
}