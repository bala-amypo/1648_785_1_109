package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseIntent;
import com.example.demo.repository.PurchaseIntentRepository;
import com.example.demo.service.PurchaseIntentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseIntentServiceImpl implements PurchaseIntentService {

    private final PurchaseIntentRepository repository;

    @Override
    public PurchaseIntent addIntent(PurchaseIntent intent) {
        return repository.save(intent);
    }

    @Override
    public PurchaseIntent getIntentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<PurchaseIntent> getIntentsByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<PurchaseIntent> getAllIntents() {
        return repository.findAll();
    }
}
