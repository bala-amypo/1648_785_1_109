package com.example.demo.controller;

import com.example.demo.entity.UserProfile;
import com.example.demo.service.UserProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {

  private final UserProfileService service;

  public UserProfileController(UserProfileService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<UserProfile> create(@RequestBody UserProfile profile) {
    return ResponseEntity.ok(service.createUser(profile));
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserProfile> getById(@PathVariable Long id) {
    return ResponseEntity.ok(service.getUserById(id));
  }

  @GetMapping
  public ResponseEntity<List<UserProfile>> getAll() {
    return ResponseEntity.ok(service.getAllUsers());
  }

  @PutMapping("/{id}/status")
  public ResponseEntity<UserProfile> setStatus(@PathVariable Long id, @RequestParam boolean active) {
    return ResponseEntity.ok(service.updateUserStatus(id, active));
  }

  @GetMapping("/lookup/{userId}")
  public ResponseEntity<UserProfile> lookup(@PathVariable String userId) {
    return ResponseEntity.ok(service.findByUserId(userId));
  }
}
