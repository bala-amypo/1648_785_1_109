package com.example.demo.service;

import com.example.demo.entity.CreditCardRecord;
import java.util.List;

public interface RecommendationEngineService {

    CreditCardRecord generateRecommendation(Long userId);

    List<CreditCardRecord> getRecommendationsByUser(Long userId);

    List<CreditCardRecord> getAllRecommendations();
}
