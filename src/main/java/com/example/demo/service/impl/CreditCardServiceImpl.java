package com.example.demo.service.impl;

import com.example.demo.service.CreditCardService;
import org.springframework.stereotype.Service;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    @Override
    public int calculateRewardPoints(double amount) {
        // simple example: 1 point per $10
        return (int) (amount / 10);
    }
}
