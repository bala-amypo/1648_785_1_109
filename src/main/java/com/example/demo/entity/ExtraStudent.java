package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ExtraStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Ensure this is Long (capital L)

    private String email;
    private String password;
    private String role;

    // The missing method:
    public Long getId() {
        return id;
    }

    // Standard getters and setters for other fields
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}