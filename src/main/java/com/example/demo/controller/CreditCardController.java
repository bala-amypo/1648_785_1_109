package com.example.demo.controller;

import com.example.demo.entity.CreditCardRecord;
import com.example.demo.service.CreditCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CreditCardController {

    private final CreditCardService cardService;

    @PostMapping
    public CreditCardRecord addCard(@RequestBody CreditCardRecord card) {
        return cardService.addCard(card);
    }

    @GetMapping("/{id}")
    public CreditCardRecord getCardById(@PathVariable Long id) {
        return cardService.getCardById(id);
    }

    @GetMapping("/user/{userId}")
    public List<CreditCardRecord> getCardsByUser(@PathVariable Long userId) {
        return cardService.getCardsByUser(userId);
    }

    @GetMapping
    public List<CreditCardRecord> getAllCards() {
        return cardService.getAllCards();
    }
}
