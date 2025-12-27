package com.example.demo.entity;

import lombok.Data;
// Change javax to jakarta here:
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Data
public class RecommendationRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long userId;
    private Long purchaseIntentId;
    private Long recommendedCardId;
    private double expectedRewardValue;
    
    @Column(columnDefinition = "TEXT")
    private String calculationDetailsJson;
}