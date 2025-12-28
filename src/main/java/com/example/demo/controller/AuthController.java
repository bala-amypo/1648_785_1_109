package com.example.demo.controller;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserProfile;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final UserProfileService userService;
  private final UserProfileRepository userRepo;
  private final AuthenticationManager authManager;
  private final JwtUtil jwtUtil;

  public AuthController(UserProfileService userService,
                        UserProfileRepository userRepo,
                        AuthenticationManager authenticationManager,
                        JwtUtil jwtUtil) {
    this.userService = userService;
    this.userRepo = userRepo;
    this.authManager = authenticationManager;
    this.jwtUtil = jwtUtil;
  }

  @PostMapping("/register")
  public ResponseEntity<JwtResponse> register(@RequestBody RegisterRequest req) {
    if (userRepo.existsByEmail(req.getEmail()))
      throw new BadRequestException("Duplicate email");
    if (req.getUserId() != null && userRepo.existsByUserId(req.getUserId()))
      throw new BadRequestException("Duplicate userId");

    UserProfile u = new UserProfile();
    u.setFullName(req.getFullName());
    u.setEmail(req.getEmail());
    u.setPassword(req.getPassword());
    u.setRole(req.getRole());
    u.setUserId(req.getUserId());

    UserProfile saved = userService.createUser(u);
    String token = jwtUtil.generateToken(saved.getId(), saved.getEmail(), saved.getRole());
    return ResponseEntity.ok(new JwtResponse(token, saved.getId(), saved.getEmail(), saved.getRole()));
  }

  @PostMapping("/login")
  public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest req) {
    Authentication auth = authManager.authenticate(
        new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword())
    );

    Optional<UserProfile> opt = userRepo.findByEmail(req.getEmail());
    UserProfile user = opt.orElseThrow(() -> new BadRequestException("Invalid user"));
    if (user.getActive() != null && !user.getActive())
      throw new BadRequestException("User inactive");

    String token = jwtUtil.generateToken(user.getId(), user.getEmail(), user.getRole());
    return ResponseEntity.ok(new JwtResponse(token, user.getId(), user.getEmail(), user.getRole()));
  }
}
