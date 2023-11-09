package com.example.flashcardapi.controller;

import com.example.flashcardapi.dao.CardDao;
import com.example.flashcardapi.model.Card;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class CardController {
    private CardDao cardDao;
    String BASE_URL = "http://localhost:8080/card/";

    //Constructor
    public CardController(CardDao cardDao) {
        this.cardDao = cardDao;
    }

    //Methods
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public Card addCard(@Valid @RequestBody Card newCard){
        if (newCard == null) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Sorry, card could not be created");
        } else {
            return cardDao.addCard(newCard);
        }
    }
}
