package com.example.demo.controller;

import com.example.demo.entity.PurchaseIntentRecord;
import com.example.demo.service.PurchaseIntentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/intents")
public class PurchaseIntentController {

    private final PurchaseIntentService intentService;

    public PurchaseIntentController(PurchaseIntentService intentService) {
        this.intentService = intentService;
    }

    @PostMapping
    public ResponseEntity<PurchaseIntentRecord> createIntent(
            @RequestBody PurchaseIntentRecord intent) {

        return ResponseEntity.ok(intentService.createIntent(intent));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseIntentRecord> getIntent(@PathVariable Long id) {
        return ResponseEntity.ok(intentService.getIntentById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PurchaseIntentRecord>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(intentService.getIntentsByUser(userId));
    }

    @GetMapping
    public ResponseEntity<List<PurchaseIntentRecord>> getAllIntents() {
        return ResponseEntity.ok(intentService.getAllIntents());
    }
}
