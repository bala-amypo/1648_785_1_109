package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CreditCardRecord {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;
    private String cardName;
    private String issuer;
    private String status;
    private Double annualFee = 0.0;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // getters and setters
}
