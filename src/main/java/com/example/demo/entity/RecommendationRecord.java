package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class RecommendationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long purchaseIntentId;
    private Long recommendedCardId;
    private Double expectedRewardValue;
    private String calculationDetailsJson;

    // getters & setters
}
