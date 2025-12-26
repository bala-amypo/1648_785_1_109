package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class RewardRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cardId;
    private String category;
    private double multiplier;
    private boolean active;

    public Long getId() {
        return id;
    }

    public Long getCardId() {
        return cardId;
    }

    public String getCategory() {
        return category;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public boolean getActive() {
        return active;
    }
}
