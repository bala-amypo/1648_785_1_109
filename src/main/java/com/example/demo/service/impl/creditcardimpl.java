package com.example.demo.service.impl;

import com.example.demo.entity.creditcard;
import com.example.demo.repository.creditcardrepository;
import com.example.demo.service.creditcardservice;
import org.springframework.stereotype.Service;

import java.util.List;
   @Service
public class creditcardimpl implements creditcardservice {

    private final creditcardrepository repository;

    public creditcardimpl(creditcardrepository repository) {
        this.repository = repository;
    }
    @Override
    public creditcard addCard(creditcard card) {
    return repository.save(card);   
    }


    @Override
    public creditcard updateCard(Long id, creditcard updated) {
        creditcard existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setCardName(updated.getCardName());
            existing.setIssuer(updated.getIssuer());
            existing.setCardType(updated.getCardType());
            existing.setAnnualFee(updated.getAnnualFee());
            existing.setStatus(updated.getStatus());
            existing.setUserId(updated.getUserId());
            return repository.save(existing);
        }
        return null;
    }

    @Override
    public creditcard getCardByUser(Long userId) {
        return repository.findByUserId(userId).orElse(null);
    }

    @Override
    public creditcard getCardById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<creditcard> getAllCard() {
        return repository.findAll();
    }
}
