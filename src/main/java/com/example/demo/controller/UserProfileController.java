package com.example.demo.controller;

import com.example.demo.entity.UserProfile;
import com.example.demo.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {

    @Autowired
    private UserProfileService userService;

    @GetMapping
    public List<UserProfile> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public UserProfile createUser(@RequestBody UserProfile profile) {
        return userService.createUser(profile);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Void> updateStatus(@PathVariable Long id, @RequestParam boolean active) {
        userService.updateUserStatus(id, active);
        return ResponseEntity.ok().build();
    }
}