package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseIntent;
import com.example.demo.service.PurchaseIntentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseIntentServiceImpl implements PurchaseIntentService {

    private final List<PurchaseIntent> intents = new ArrayList<>();

    @Override
    public PurchaseIntent addIntent(PurchaseIntent intent) {
        intents.add(intent);
        return intent;
    }

    @Override
    public PurchaseIntent getIntentById(Long id) {
        Optional<PurchaseIntent> intent = intents.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst();
        return intent.orElse(null);
    }

    @Override
    public List<PurchaseIntent> getIntentsByUser(Long userId) {
        List<PurchaseIntent> userIntents = new ArrayList<>();
        for (PurchaseIntent intent : intents) {
            if (intent.getUserId().equals(userId)) {
                userIntents.add(intent);
            }
        }
        return userIntents;
    }

    @Override
    public List<PurchaseIntent> getAllIntents() {
        return new ArrayList<>(intents);
    }
}
