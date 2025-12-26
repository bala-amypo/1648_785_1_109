package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class RecommendationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long purchaseIntentId;
    private Long recommendedCardId;
    private double rewardPoints;
    private String calculationDetailsJson;

    public void setPurchaseIntentId(Long purchaseIntentId) {
        this.purchaseIntentId = purchaseIntentId;
    }

    public void setCalculationDetailsJson(String calculationDetailsJson) {
        this.calculationDetailsJson = calculationDetailsJson;
    }
}
