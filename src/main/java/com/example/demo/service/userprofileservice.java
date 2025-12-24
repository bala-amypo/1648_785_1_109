package com.example.demo.service;
import com.example.demo.entity.userprofile;
import java.util.List;
import java.util.Optional;

public interface userprofileservice {

    userprofile createUser(userprofile profile);
    userprofile getUserById(Long id);
    userprofile findByUserId(String userId);
    List<userprofile> getAllUsers();
    Optional<userprofile> findByEmail(String email);
    userprofile updateUserStatus(Long id, boolean active);
}
