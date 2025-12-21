package com.example.demo.controller;

import com.example.demo.entity.userprofile;
import com.example.demo.service.userprofileservice;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class userprofilecontroller {

     private final userprofileservice ser;

    // Constructor Injection
    public Userprofilecontroller(userprofileservice ser) {
        this.ser = ser;
    }

    @PostMapping("/POST")
    public userprofile create(@RequestBody userprofile profile) {
        return ser.createUser(profile);
    }

    @GetMapping("/GET/{id}")
    public userprofile getById(@PathVariable Long id) {
        return ser.getUserById(id);
    }

    @GetMapping("/GET")
    public List<userprofile> getAll() {
        return ser.getAllUsers();
    }

    @PutMapping("/PUT/{id}/status")
    public userprofile updateStatus(@PathVariable Long id,@RequestParam boolean active) {
        return ser.updateUserStatus(id, active);
    }

    @GetMapping("/PUT/lookup/{userId}")
    public userprofile lookup(@PathVariable String userId) {
        return ser.findByUserId(userId);
    }
}
