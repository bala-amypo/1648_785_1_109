package com.example.demo.controller;

import com.example.demo.entity.PurchaseIntent;
import com.example.demo.service.PurchaseIntentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-intents")
@RequiredArgsConstructor
public class PurchaseIntentController {

    private final PurchaseIntentService purchaseIntentService;

    @PostMapping
    public PurchaseIntent addIntent(@RequestBody PurchaseIntent intent) {
        return purchaseIntentService.addIntent(intent);
    }

    @GetMapping("/{id}")
    public PurchaseIntent getIntentById(@PathVariable Long id) {
        return purchaseIntentService.getIntentById(id);
    }

    @GetMapping("/user/{userId}")
    public List<PurchaseIntent> getIntentsByUser(@PathVariable Long userId) {
        return purchaseIntentService.getIntentsByUser(userId);
    }

    @GetMapping
    public List<PurchaseIntent> getAllIntents() {
        return purchaseIntentService.getAllIntents();
    }
}
