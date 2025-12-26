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
    public CreditCardRecord recommendBestCard(Long userId) {
        List<CreditCardRecord> cards = creditCardRepository.findByUserId(userId);
        return cards.stream()
                .max(Comparator.comparingDouble(CreditCardRecord::getBalance)) // example: max balance
                .orElse(null);
    }
}
