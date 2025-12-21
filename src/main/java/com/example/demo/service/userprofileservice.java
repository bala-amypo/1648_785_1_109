package com.example.demo.service;
import com.example.demo.entity.userprofile;
import java.util.List;

public interface userprofileservice {

    userprofile createUser(userprofile profile);
    userprofile getUserById(Long id);
    userprofile findByUserId(String userId);
    List<userprofile> getAllUsers();
    userprofile updateUserStatus(Long id, boolean active);
}
