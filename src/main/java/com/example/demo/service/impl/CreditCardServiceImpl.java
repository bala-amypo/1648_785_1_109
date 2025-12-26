package com.example.demo.service.impl;

import com.example.demo.entity.CreditCardRecord;
import com.example.demo.service.CreditCardService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    // Temporary in-memory storage for demo purposes
    private final List<CreditCardRecord> cards = new ArrayList<>();

    @Override
    public CreditCardRecord addCard(CreditCardRecord card) {
        cards.add(card);
        return card;
    }

    @Override
    public CreditCardRecord getCardById(Long cardId) {
        Optional<CreditCardRecord> card = cards.stream()
                .filter(c -> c.getId().equals(cardId))
                .findFirst();
        return card.orElse(null);
    }

    @Override
    public List<CreditCardRecord> getCardsByUser(Long userId) {
        List<CreditCardRecord> userCards = new ArrayList<>();
        for (CreditCardRecord card : cards) {
            if (card.getUserId().equals(userId)) {
                userCards.add(card);
            }
        }
        return userCards;
    }

    @Override
    public List<CreditCardRecord> getAllCards() {
        return new ArrayList<>(cards);
    }
}
