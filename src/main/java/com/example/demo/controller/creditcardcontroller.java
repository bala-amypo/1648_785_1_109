package com.example.demo.controller;

import com.example.demo.entity.creditcard;
import com.example.demo.service.creditcardservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Creditcard")
public class creditcardcontroller {

    private final creditcardservice service;

    public creditcardcontroller(creditcardservice service) {
        this.service = service;
    }

    @PostMapping("/POST")
    public creditcard addCard(@RequestBody creditcard card) {
        return service.addCard(card);
    }

    @PutMapping("/PUT/{id}")
    public creditcard updateCard(
            @PathVariable Long id,
            @RequestBody creditcard updatedCard) {
        return service.updateCard(id, updatedCard);
    }

  @GetMapping("/GET/{id}")
    public creditcard getCard(@PathVariable Long id) {
    return service.getCardById(id);
}


    @GetMapping("/GET/user/{userId}")
    public creditcard getCardByUser(@PathVariable Long userId) {
        return service.getCardByUser(userId);
    }

    @GetMapping("/GET ")
    public List<creditcard> getAllCards() {
        return service.getAllCard();
    }
}
