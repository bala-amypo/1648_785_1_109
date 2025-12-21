package com.example.demo.controller;

import com.example.demo.entity.UserProfile;
import com.example.demo.service.UserProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Profile")
public class UserProfileController {

    private final UserProfileService service;

    public UserProfileController(UserProfileService service) {
        this.service = service;
    }

    @PostMapping
    public UserProfile create(@RequestBody UserProfile profile) {
        return service.createUser(profile);
    }

    @GetMapping("/{id}")
    public UserProfile getById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @GetMapping
    public List<UserProfile> getAll() {
        return service.getAllUsers();
    }

    @PutMapping("/{id}/status")
    public UserProfile updateStatus(@PathVariable Long id,
                                    @RequestParam boolean active) {
        return service.updateUserStatus(id, active);
    }

    @GetMapping("/lookup/{userId}")
    public UserProfile lookup(@PathVariable String userId) {
        return service.findByUserId(userId);
    }
}
