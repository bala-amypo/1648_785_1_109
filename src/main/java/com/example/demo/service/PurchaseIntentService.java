package com.example.demo.service;

import com.example.demo.entity.PurchaseIntent;

import java.util.List;

public interface PurchaseIntentService {
    PurchaseIntent addIntent(PurchaseIntent intent);
    PurchaseIntent getIntentById(Long id);
    List<PurchaseIntent> getIntentsByUser(Long userId);
    List<PurchaseIntent> getAllIntents();
}
