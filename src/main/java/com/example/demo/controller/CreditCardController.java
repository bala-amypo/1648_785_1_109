package com.example.demo.controller;

import com.example.demo.entity.CreditCardRecord;
import com.example.demo.service.CreditCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/CreditCardController")
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CreditCardController {

    private final CreditCardService cardService;

    @PostMapping("/POST")
    public CreditCardRecord addCard(@RequestBody CreditCardRecord card) {
        return cardService.addCard(card);
    }

    @GetMapping("/GET/{id}")
    public CreditCardRecord getCardById(@PathVariable Long id) {
        return cardService.getCardById(id);
    }

    @GetMapping("/GET/user/{userId}")
    public List<CreditCardRecord> getCardsByUser(@PathVariable Long userId) {
        return cardService.getCardsByUser(userId);
    }

    @GetMapping("/GET")
    public List<CreditCardRecord> getAllCards() {
        return cardService.getAllCards();
    }
}
