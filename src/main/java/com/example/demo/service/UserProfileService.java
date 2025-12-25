package com.example.demo.service;
import com.example.demo.entity.userprofile;
import java.util.List;

public interface UserProfileService {
    UserProfile createUser(UserProfile u);
    UserProfile getUserById(Long id);
    List<UserProfile> getAllUsers();
}
