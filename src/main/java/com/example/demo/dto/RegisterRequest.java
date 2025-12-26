package com.example.demo.dto;

import com.example.demo.entity.UserProfile;

public class RegisterRequest {

    private String userId;
    private String fullName;
    private String email;
    private String password;
    private String role;

    public RegisterRequest() {}

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }

    /* Helper for controller/service */
    public UserProfile toUserProfile() {
        UserProfile user = new UserProfile();
        user.setUserId(this.userId);
        user.setFullName(this.fullName);
        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setRole(this.role);
        return user;
    }
}
