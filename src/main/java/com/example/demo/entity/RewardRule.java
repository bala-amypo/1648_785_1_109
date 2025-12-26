package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RewardRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private String description;
    private Double rewardPercentage;

    // No-args constructor
    public RewardRule() {
    }

    // All-args constructor
    public RewardRule(Long id, String ruleName, String description, Double rewardPercentage) {
        this.id = id;
        this.ruleName = ruleName;
        this.description = description;
        this.rewardPercentage = rewardPercentage;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRewardPercentage() {
        return rewardPercentage;
    }

    public void setRewardPercentage(Double rewardPercentage) {
        this.rewardPercentage = rewardPercentage;
    }

    // toString()
    @Override
    public String toString() {
        return "RewardRule{" +
                "id=" + id +
                ", ruleName='" + ruleName + '\'' +
                ", description='" + description + '\'' +
                ", rewardPercentage=" + rewardPercentage +
                '}';
    }
}
