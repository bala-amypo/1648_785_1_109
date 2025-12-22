package com.example.demo.controller;

import com.example.demo.entity.purchaseintent;
import com.example.demo.service.purchaseintentservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/PurchaseIntent")
public class purchaseintentcontroller {

    private final purchaseintentservice service;

    public purchaseintentcontroller(purchaseintentservice service) {
        this.service = service;
    }

    @PostMapping("/POST")
    public purchaseintent createIntent(@RequestBody purchaseintent intent) {
        return service.createIntent(intent);
    }

    @GetMapping("/GET/user/{userId}")
    public List<purchaseintent> getIntentsByUser(@PathVariable Long userId) {
        return service.getIntentsByUser(userId);
    }

    @GetMapping("/GET/{id}")
    public purchaseintent getIntentById(@PathVariable Long id) {
        return service.getIntentById(id);
    }
    


    @GetMapping("/GET")
    public List<purchaseintent> getAllIntents() {
        return service.getAllIntents();
    }
}