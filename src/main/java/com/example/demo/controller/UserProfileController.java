package com.example.demo.controller;

import com.example.demo.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {

    @Autowired
    private UserProfileService userService;

    // FIX: Ensure this method name is unique and handles void returns correctly
    @PutMapping("/{id}/status")
    public ResponseEntity<Void> updateStatus(@PathVariable Long id, @RequestParam boolean active) {
        userService.updateStatus(id, active); 
        return ResponseEntity.ok().build(); // Correct way to return 'void' success
    }

    // REMOVE or RENAME any other method named 'updateStatus' that takes (Long, boolean)
}