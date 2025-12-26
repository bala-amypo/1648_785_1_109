package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CreditCardRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String cardNumber;
    private String cardHolderName;
    private String cardType;
    private Double balance;

    // No-args constructor (required by JPA)
    public CreditCardRecord() {
    }

    // All-args constructor
    public CreditCardRecord(Long id, Long userId, String cardNumber, String cardHolderName, String cardType, Double balance) {
        this.id = id;
        this.userId = userId;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cardType = cardType;
        this.balance = balance;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getCardType() {
        return cardType;
    }

    public Double getBalance() {
        return balance;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    // toString()
    @Override
    public String toString() {
        return "CreditCardRecord{" +
                "id=" + id +
                ", userId=" + userId +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", cardType='" + cardType + '\'' +
                ", balance=" + balance +
                '}';
    }
}
