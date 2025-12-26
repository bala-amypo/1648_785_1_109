package com.example.demo.service;

import com.example.demo.entity.RecommendationRecord;
import java.util.List;

public interface RecommendationEngineService {
    // These must return RecommendationRecord, not CreditCardRecord
    RecommendationRecord generateRecommendation(Long intentId);
    List<RecommendationRecord> getAllRecommendations();
    List<RecommendationRecord> getRecommendationsByUser(Long userId);
}