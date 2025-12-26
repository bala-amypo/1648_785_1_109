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
    private double expectedRewardValue;
    private String calculationDetailsJson;

    // No-args constructor
    public RecommendationRecord() {
    }

    // All-args constructor
    public RecommendationRecord(Long id, Long userId, Long purchaseIntentId, Long recommendedCardId,
                                double expectedRewardValue, String calculationDetailsJson) {
        this.id = id;
        this.userId = userId;
        this.purchaseIntentId = purchaseIntentId;
        this.recommendedCardId = recommendedCardId;
        this.expectedRewardValue = expectedRewardValue;
        this.calculationDetailsJson = calculationDetailsJson;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getPurchaseIntentId() {
        return purchaseIntentId;
    }

    public Long getRecommendedCardId() {
        return recommendedCardId;
    }

    public double getExpectedRewardValue() {
        return expectedRewardValue;
    }

    public String getCalculationDetailsJson() {
        return calculationDetailsJson;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setPurchaseIntentId(Long purchaseIntentId) {
        this.purchaseIntentId = purchaseIntentId;
    }

    public void setRecommendedCardId(Long recommendedCardId) {
        this.recommendedCardId = recommendedCardId;
    }

    public void setExpectedRewardValue(double expectedRewardValue) {
        this.expectedRewardValue = expectedRewardValue;
    }

    public void setCalculationDetailsJson(String calculationDetailsJson) {
        this.calculationDetailsJson = calculationDetailsJson;
    }

    // toString()
    @Override
    public String toString() {
        return "RecommendationRecord{" +
                "id=" + id +
                ", userId=" + userId +
                ", purchaseIntentId=" + purchaseIntentId +
                ", recommendedCardId=" + recommendedCardId +
                ", expectedRewardValue=" + expectedRewardValue +
                ", calculationDetailsJson='" + calculationDetailsJson + '\'' +
                '}';
    }
}
