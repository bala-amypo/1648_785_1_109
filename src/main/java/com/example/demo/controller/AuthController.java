package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.ExtraStudent;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.ExtraStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*") 
public class AuthController {

    @Autowired
    private ExtraStudentService ser;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtUtil util;

    @PostMapping("/add")
    public ExtraStudent addExtraStudent(@RequestBody ExtraStudent stu) {
        // Encode password before saving
        stu.setPassword(encoder.encode(stu.getPassword()));
        return ser.saveExtraStudent(stu);
    }
@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody AuthRequest request) {
    ExtraStudent student = ser.CheckEmail(request.getEmail());
    
    if (student == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
    }

    if (!encoder.matches(request.getPassword(), student.getPassword())) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    // FIX IS HERE: Added student.getId() as the first argument
    String token = util.generateToken(
            student.getId(), 
            student.getEmail(),
            student.getRole()
    );

    // Ensure AuthResponse also takes ID if your constructor requires it
    return ResponseEntity.ok(new AuthResponse(token, student.getRole()));
}
}