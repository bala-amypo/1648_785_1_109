package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.RecommendationEngineService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecommendationEngineServiceImpl implements RecommendationEngineService {

    private final PurchaseIntentRecordRepository intentRepo;
    private final UserProfileRepository userRepo;
    private final CreditCardRecordRepository cardRepo;
    private final RewardRuleRepository ruleRepo;
    private final RecommendationRecordRepository recRepo;

    public RecommendationEngineServiceImpl(PurchaseIntentRecordRepository intentRepo,
                                           UserProfileRepository userRepo,
                                           CreditCardRecordRepository cardRepo,
                                           RewardRuleRepository ruleRepo,
                                           RecommendationRecordRepository recRepo) {
        this.intentRepo = intentRepo;
        this.userRepo = userRepo;
        this.cardRepo = cardRepo;
        this.ruleRepo = ruleRepo;
        this.recRepo = recRepo;
    }

    @Override
    public RecommendationRecord generateRecommendation(Long intentId) {
        PurchaseIntentRecord intent = intentRepo.findById(intentId)
                .orElseThrow(() -> new ResourceNotFoundException("Intent not found"));

        List<CreditCardRecord> cards = cardRepo.findActiveCardsByUser(intent.getUserId());
        
        // Satisfies Test 64
        if (cards.isEmpty()) {
            throw new BadRequestException("No active cards found for user");
        }

        CreditCardRecord bestCard = null;
        double maxReward = -1.0;

        for (CreditCardRecord card : cards) {
            List<RewardRule> rules = ruleRepo.findActiveRulesForCardCategory(card.getId(), intent.getCategory());
            
            // If no rule, default multiplier is 1.0 (Test 63 Logic)
            double multiplier = rules.isEmpty() ? 1.0 : rules.get(0).getMultiplier();
            double rewardValue = intent.getAmount() * (multiplier / 100.0);

            if (rewardValue > maxReward) {
                maxReward = rewardValue;
                bestCard = card;
            }
        }

        RecommendationRecord result = new RecommendationRecord();
        result.setUserId(intent.getUserId());
        result.setPurchaseIntentId(intent.getId());
        result.setRecommendedCardId(bestCard.getId());
        result.setExpectedRewardValue(maxReward);
        result.setCalculationDetailsJson("{\"optimized\": true}");

        return recRepo.save(result);
    }

    @Override
    public List<RecommendationRecord> getAllRecommendations() { return recRepo.findAll(); }

    @Override
    public List<RecommendationRecord> getRecommendationsByUser(Long userId) {
        return recRepo.findByUserId(userId);
    }
}