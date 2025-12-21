package com.example.demo.controller;

import com.example.demo.entity.creditcard;
import com.example.demo.service.creditcardservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/creditcards")
public class creditcardcontroller {

    private final creditcardservice service;

    // Constructor Injection
    public creditcardcontroller(creditcardservice service) {
        this.service = service;
    }

    // Add new credit card
    @PostMapping("/add")
    public creditcard addCard(@RequestBody creditcard card) {
        return service.addCard(card);
    }

    // Update credit card by id
    @PutMapping("/update/{id}")
    public creditcard updateCard(
            @PathVariable Long id,
            @RequestBody creditcard updatedCard) {
        return service.updateCard(id, updatedCard);
    }

    // Get credit card by card id
    @GetMapping("/{id}")
    public creditcard getCardById(@PathVariable Long id) {
        return service.getCardById(id);
    }

    // Get credit card by user id
    @GetMapping("/user/{userId}")
    public creditcard getCardByUser(@PathVariable Long userId) {
        return service.getCardByUser(userId);
    }

    // Get all credit cards
    @GetMapping("/all")
    public List<creditcard> getAllCards() {
        return service.getAllCard();
    }
}
