package com.example.demo.entity;
import jakarta.persistence.*;

@Entity
public class PurchaseIntentRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String category;
    private double amount;

    // Add these methods:
    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public String getCategory() { return category; }
    public double getAmount() { return amount; }
}