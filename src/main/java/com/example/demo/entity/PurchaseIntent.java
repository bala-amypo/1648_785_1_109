package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PurchaseIntent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String product;
    private Double amount;
    private String status;

    // No-args constructor
    public PurchaseIntent() {
    }

    // All-args constructor
    public PurchaseIntent(Long id, Long userId, String product, Double amount, String status) {
        this.id = id;
        this.userId = userId;
        this.product = product;
        this.amount = amount;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString()
    @Override
    public String toString() {
        return "PurchaseIntent{" +
                "id=" + id +
                ", userId=" + userId +
                ", product='" + product + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}
