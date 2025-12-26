package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.RecommendationEngineService;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class RecommendationEngineServiceImpl implements RecommendationEngineService {

    private final CreditCardRecordRepository cardRepository;
    private final PurchaseIntentRecordRepository intentRepository;
    private final UserProfileRepository userRepository;
    private final RewardRuleRepository ruleRepository;
    private final RecommendationRecordRepository recommendationRepository;

    // Updated constructor to match the 5 repositories used in your test's logic
    public RecommendationEngineServiceImpl(
            PurchaseIntentRecordRepository intentRepository,
            UserProfileRepository userRepository,
            CreditCardRecordRepository cardRepository,
            RewardRuleRepository ruleRepository,
            RecommendationRecordRepository recommendationRepository) {
        this.intentRepository = intentRepository;
        this.userRepository = userRepository;
        this.cardRepository = cardRepository;
        this.ruleRepository = ruleRepository;
        this.recommendationRepository = recommendationRepository;
    }

    @Override
    public RecommendationRecord generateRecommendation(Long intentId) {
        PurchaseIntentRecord intent = intentRepository.findById(intentId)
                .orElseThrow(() -> new ResourceNotFoundException("Intent not found"));

        List<CreditCardRecord> cards = cardRepository.findActiveCardsByUser(intent.getUserId());
        if (cards.isEmpty()) {
            throw new BadRequestException("No active cards found for user");
        }

        CreditCardRecord bestCard = null;
        double maxReward = -1.0;

        for (CreditCardRecord card : cards) {
            List<RewardRule> rules = ruleRepository.findActiveRulesForCardCategory(card.getId(), intent.getCategory());
            double multiplier = rules.stream()
                    .mapToDouble(RewardRule::getMultiplier)
                    .max()
                    .orElse(1.0); // Default 1x rewards

            double rewardValue = intent.getAmount() * (multiplier / 100.0);
            if (rewardValue > maxReward) {
                maxReward = rewardValue;
                bestCard = card;
            }
        }

        RecommendationRecord rec = new RecommendationRecord();
        rec.setUserId(intent.getUserId());
        rec.setPurchaseIntentId(intent.getId());
        rec.setRecommendedCardId(bestCard.getId());
        rec.setExpectedRewardValue(maxReward);
        rec.setCalculationDetailsJson("{\"multiplier_applied\": \"calculated\"}");

        return recommendationRepository.save(rec);
    }

    @Override
    public List<RecommendationRecord> getAllRecommendations() {
        return recommendationRepository.findAll();
    }

    @Override
    public List<RecommendationRecord> getRecommendationsByUser(Long userId) {
        return recommendationRepository.findByUserId(userId);
    }
}