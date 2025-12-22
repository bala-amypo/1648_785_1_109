package com.example.demo.controller;

import com.example.demo.entity.purchaseintent;
import com.example.demo.service.purchaseintentservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PurchaseIntent")
public class purchaseintentcontroller {

    private final purchaseintentservice service;

    // Constructor Injection
    public purchaseintentcontroller(purchaseintentservice service) {
        this.service = service;
    }

    // Create purchase intent
    @PostMapping("/POST")
    public purchaseintent createIntent(@RequestBody purchaseintent intent) {
        return service.createIntent(intent);
    }

    // Get intents by user ID
    @GetMapping("/GET/user/{userId}")
    public List<purchaseintent> getIntentsByUser(@PathVariable Long userId) {
        return service.getIntentsByUser(userId);
    }

    // Get intent by ID
    @GetMapping("/GET/{id}")
    public purchaseintent getIntentById(@PathVariable Long id) {
        return service.getIntentById(id);
    }

    // Get all purchase intents
    @GetMapping("/GET")
    public List<purchaseintent> getAllIntents() {
        return service.getAllIntents();
    }
}