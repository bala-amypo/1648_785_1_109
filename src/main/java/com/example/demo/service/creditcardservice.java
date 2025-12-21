package com.example.demo.service;
import com.example.demo.entity.creditcard;
import java.util.List;

public interface creditcardservice {

    creditcard addCard(creditcard card);
    creditcard updateCard(Long id,creditcard updated);
    creditcard getCardByUser(Long userId);
    creditcard getCardById(Long id);
    List<creditcard> getAllCard();
}
