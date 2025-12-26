package com.example.demo.service.impl;

import com.example.demo.entity.CreditCardRecord;
import com.example.demo.repository.CreditCardRepository;
import com.example.demo.service.RecommendationEngineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationEngineServiceImpl implements RecommendationEngineService {

    private final CreditCardRepository creditCardRepository;

    @Override
    public CreditCardRecord generateRecommendation(Long userId) {
        return creditCardRepository.findByUserId(userId).stream()
                .max(Comparator.comparingDouble(CreditCardRecord::getBalance))
                .orElse(null);
    }

    @Override
    public List<CreditCardRecord> getRecommendationsByUser(Long userId) {
        return creditCardRepository.findByUserId(userId);
    }

    @Override
    public List<CreditCardRecord> getAllRecommendations() {
        return creditCardRepository.findAll();
    }
}
