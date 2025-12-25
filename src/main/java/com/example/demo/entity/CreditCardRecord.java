entity


package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cards")
public class CreditCardRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String cardName;
    private String issuer;
    private String cardType;
    private Double annualFee;
    private String status;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getCardName() { return cardName; }
    public void setCardName(String cardName) { this.cardName = cardName; }
    public String getIssuer() { return issuer; }
    public void setIssuer(String issuer) { this.issuer = issuer; }
    public String getCardType() { return cardType; }
    public void setCardType(String cardType) { this.cardType = cardType; }
    public Double getAnnualFee() { return annualFee; }
    public void setAnnualFee(Double annualFee) { this.annualFee = annualFee; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}

package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchase_intents")
public class PurchaseIntentRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Double amount;
    private String category;
    private String merchant;
    private LocalDateTime intentDate;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getMerchant() { return merchant; }
    public void setMerchant(String merchant) { this.merchant = merchant; }
    public LocalDateTime getIntentDate() { return intentDate; }
    public void setIntentDate(LocalDateTime intentDate) { this.intentDate = intentDate; }
}

package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "recommendations")
public class RecommendationRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long purchaseIntentId;
    private Long recommendedCardId;
    private Double expectedRewardValue;
    @Column(columnDefinition = "TEXT")
    private String calculationDetailsJson;
    private LocalDateTime recommendedAt;

    @PrePersist
    public void prePersist() {
        this.recommendedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Long getPurchaseIntentId() { return purchaseIntentId; }
    public void setPurchaseIntentId(Long purchaseIntentId) { this.purchaseIntentId = purchaseIntentId; }
    public Long getRecommendedCardId() { return recommendedCardId; }
    public void setRecommendedCardId(Long recommendedCardId) { this.recommendedCardId = recommendedCardId; }
    public Double getExpectedRewardValue() { return expectedRewardValue; }
    public void setExpectedRewardValue(Double expectedRewardValue) { this.expectedRewardValue = expectedRewardValue; }
    public String getCalculationDetailsJson() { return calculationDetailsJson; }
    public void setCalculationDetailsJson(String calculationDetailsJson) { this.calculationDetailsJson = calculationDetailsJson; }
    public LocalDateTime getRecommendedAt() { return recommendedAt; }
}