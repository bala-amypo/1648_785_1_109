package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class CreditCardRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardName;
    private String issuer;
    private String status;
    private double annualFee;

    public Long getId() {
        return id;
    }

    public String getCardName() {
        return cardName;
    }

    public String getIssuer() {
        return issuer;
    }

    public String getStatus() {
        return status;
    }

    public double getAnnualFee() {
        return annualFee;
    }
}
