package com.example.demo.service;
import com.example.demo.entity.userprofile;
public class userprofileservice{
userprofile createUser(userprofile,profile);
userprofile getUserById(Lond id);
userprofile findByUserId(String userId);
userprofile getAllUsers();
userprofile UpdateUserStatus(Long id,boolean active);
}