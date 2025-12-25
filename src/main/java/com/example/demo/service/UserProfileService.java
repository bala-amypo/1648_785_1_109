package com.example.demo.service;

import com.example.demo.entity.UserProfile;  // ✅ CORRECT CASE

public interface UserProfileService {

    UserProfile register(UserProfile user);

    UserProfile login(String email, String password);
}
