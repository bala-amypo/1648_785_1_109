package com.example.demo.service;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserProfile;
import java.util.List;

public interface UserProfileService {
    UserProfile createUser(UserProfile profile);
    void registerUser(RegisterRequest request);
    UserProfile getUserById(Long id);
    List<UserProfile> getAllUsers();
    
    // ADD THIS METHOD TO FIX THE ERROR
    void updateUserStatus(Long id, boolean active);
}