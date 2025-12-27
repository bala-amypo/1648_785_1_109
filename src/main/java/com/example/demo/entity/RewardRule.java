package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class RewardRule {

    @Id
    @GeneratedValue
    private Long id;

    private Long cardId;
    private String category;
    private Double multiplier;
    private Boolean active;

    // getters & setters
    public Long getCardId() { return cardId; }
    public void setCardId(Long cardId) { this.cardId = cardId; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Double getMultiplier() { return multiplier; }
    public void setMultiplier(Double multiplier) { this.multiplier = multiplier; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
