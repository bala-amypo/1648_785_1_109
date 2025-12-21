package com.example.demo.service;

import com.example.demo.entity.recommendation;
import java.util.List;

public interface recommendationservice {

    // Generate recommendation based on purchase intent
    recommendation generateRecommendation(Long intentId);

    // Get recommendation by ID
    recommendation getRecommendationById(Long id);

    // Get recommendations by user
    List<recommendation> getRecommendationByUser(Long userId);

    // Get all recommendations
    List<recommendation> getAllRecommendations();
}
