package com.example.demo.entity;
import jakarta.persistence.*;

@Entity
public class UserProfile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private boolean active;

    // Add these methods:
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public boolean getActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}