package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;   // 👈 ADD THIS

    private String fullName;
    private String email;
    private String password;

    // getters & setters
}

