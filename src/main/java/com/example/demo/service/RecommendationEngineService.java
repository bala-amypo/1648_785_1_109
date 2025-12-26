package com.example.demo.service;

import com.example.demo.entity.CreditCardRecord;

public interface RecommendationEngineService {
    CreditCardRecord recommendBestCard(Long userId);
}
