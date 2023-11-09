package org.flashcard.services;

import org.flashcard.model.Card;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


public class CardService {
    RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "http://localhost/8080/card";

    public Card addCard(Card newCard){
        HttpEntity<Card> entity = makeEntity(newCard);
        Card returnedCard = null;
        try{
            returnedCard = restTemplate.postForObject(BASE_URL,entity,Card.class);
        } catch (RestClientException e){
            System.out.println("Sorry, could not add your card.");
        }
        return returnedCard;
    }

    public HttpEntity<Card> makeEntity(Card card){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(card,headers);
    }
}
