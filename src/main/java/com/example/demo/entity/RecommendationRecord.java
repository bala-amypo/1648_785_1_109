package com.example.demo.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data // This generates getId, setId, setUserId, etc.
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