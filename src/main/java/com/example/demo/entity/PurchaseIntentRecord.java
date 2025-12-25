package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class PurchaseIntentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Double amount;
    private String category;
    private String merchant;

    // getters & setters
}
