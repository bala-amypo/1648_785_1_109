package com.example.demo.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data // This generates setRecommendedCardId() automatically
public class RecommendationRecord {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long userId;
    private Long purchaseIntentId;
    
    // Ensure this exact name is used:
    private Long recommendedCardId; 
    
    private double expectedRewardValue;
    
    @Column(columnDefinition = "TEXT")
    private String calculationDetailsJson;
}