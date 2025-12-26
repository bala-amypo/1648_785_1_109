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
@CrossOrigin(origins = "*") // Allows frontend connection
public class AuthController {

    @Autowired
    private ExtraStudentService ser;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtUtil util;

    /**
     * Register/Add a new student with an encoded password
     */
    @PostMapping("/add")
    public ResponseEntity<ExtraStudent> addExtraStudent(@RequestBody ExtraStudent stu) {
        // Encode the password before saving to the database
        stu.setPassword(encoder.encode(stu.getPassword()));
        ExtraStudent savedStudent = ser.saveExtraStudent(stu);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    /**
     * Login logic comparing raw password with encoded password
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        try {
            // 1. Fetch student by email
            ExtraStudent student = ser.CheckEmail(request.getEmail());
            
            if (student == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
            }

            // 2. Check if password matches
            if (!encoder.matches(request.getPassword(), student.getPassword())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }

            // 3. Generate JWT Token
            String token = util.generateToken(
                    student.getEmail(),
                    student.getRole()
            );

            // 4. Return Response
            return ResponseEntity.ok(new AuthResponse(token, student.getRole()));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }
}