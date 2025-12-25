// package com.example.demo.service.impl;

// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.entity.purchaseintent;
// import com.example.demo.repository.purchaseintentrepository;
// import com.example.demo.service.purchaseintentservice;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class purchaseintentimpl implements purchaseintentservice {

//     private final purchaseintentrepository repository;

//     public purchaseintentimpl(purchaseintentrepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public purchaseintent createIntent(purchaseintent intent) {
//         return repository.save(intent);
//     }

//     @Override
//     public List<purchaseintent> getIntentsByUser(Long userId) {
//         return repository.findByUserId(userId);
//     }

//    @Override
//     public purchaseintent getIntentById(Long id) {
//         return repository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Purchase intent not found"));
// }

//     @Override
//     public List<purchaseintent> getAllIntents() {
//         return repository.findAll();
//     }
// }
