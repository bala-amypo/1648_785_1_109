package com.example.demo.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data // This MUST be here to provide getters and setters
public class RecommendationRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long purchaseIntentId;
    private double expectedRewardValue;
    private String calculationDetailsJson;
}