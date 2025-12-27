package com.example.demo.service;

import com.example.demo.entity.UserProfile;
import com.example.demo.dto.RegisterRequest; // Ensure this DTO exists
import java.util.List;

public interface UserProfileService {
    List<UserProfile> getAllUsers();
    UserProfile getUserById(Long id);
    UserProfile createUser(UserProfile profile);
    void updateUserStatus(Long id, boolean active);
    void registerUser(RegisterRequest request); // Needed for AuthController
}