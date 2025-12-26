package com.example.demo.service.impl;

import com.example.demo.entity.CreditCardRecord;
import com.example.demo.repository.CreditCardRecordRepository;
import com.example.demo.service.CreditCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRecordRepository repository;

    @Override
    public CreditCardRecord addCard(CreditCardRecord card) {
        return repository.save(card);
    }

    @Override
    public CreditCardRecord getCardById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<CreditCardRecord> getCardsByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<CreditCardRecord> getAllCards() {
        return repository.findAll();
    }
}
