package com.example.demo.controller;

import com.example.demo.entity.userprofile;
import com.example.demo.service.userprofileservice;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class userprofilecontroller {

    @Autowired userprofileservice service;

    @PostMapping("/POST")
    public UserProfile create(@RequestBody UserProfile profile) {
        return service.createUser(profile);
    }

    @GetMapping("/GET/{id}")
    public UserProfile getById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @GetMapping("/GET")
    public List<UserProfile> getAll() {
        return service.getAllUsers();
    }

    @PutMapping("/PUT/{id}/status")
    public UserProfile updateStatus(@PathVariable Long id,@RequestParam boolean active) {
        return service.updateUserStatus(id, active);
    }

    @GetMapping("/PUT/lookup/{userId}")
    public userprofile lookup(@PathVariable String userId) {
        return service.findByUserId(userId);
    }
}
