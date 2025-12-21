package com.example.demo.controller;

import com.example.demo.entity.userprofile;
import com.example.demo.service.userprofileservice;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.springramework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
public class userprofilecontroller {

    @Autowired userprofileservice ser;

    @PostMapping("/POST")
    public UserProfile create(@RequestBody UserProfile profile) {
        return ser.createUser(profile);
    }

    @GetMapping("/GET/{id}")
    public UserProfile getById(@PathVariable Long id) {
        return ser.getUserById(id);
    }

    @GetMapping("/GET")
    public List<UserProfile> getAll() {
        return ser.getAllUsers();
    }

    @PutMapping("/PUT/{id}/status")
    public UserProfile updateStatus(@PathVariable Long id,@RequestParam boolean active) {
        return ser.updateUserStatus(id, active);
    }

    @GetMapping("/PUT/lookup/{userId}")
    public userprofile lookup(@PathVariable String userId) {
        return ser.findByUserId(userId);
    }
}
