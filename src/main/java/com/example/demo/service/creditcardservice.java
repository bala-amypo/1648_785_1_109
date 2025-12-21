package com.example.demo.service;
import com.example.demo.entity.creditcard;
import java.util.List;

public interface creditcardservice {

    creditcard createUser(userprofile profile);
    creditcard getUserById(Long id);
    creditcard findByUserId(String userId);
    List<creditcard> getAllUsers();
    creditcard updateUserStatus(Long id, boolean active);
}
