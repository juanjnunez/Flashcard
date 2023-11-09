package com.example.flashcardapi.dao;

import com.example.flashcardapi.model.Card;

public interface CardDao {
    Card addCard(Card newCard);

    Card getCardById(int id);
}
