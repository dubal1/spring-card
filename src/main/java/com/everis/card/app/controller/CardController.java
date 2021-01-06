package com.everis.card.app.controller;

import com.everis.card.app.model.Card;
import com.everis.card.app.service.ICardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class CardController {
    /**
     * inject ICardService.
     */
    @Autowired
    private ICardService service;

    /**
     * @return getCards.
     */
    @GetMapping(value = "/core/cards")
    public Mono<ResponseEntity<Map<String, Object>>> getCards() {
        Map<String, Object> objectMap = new HashMap<>();
        return service.findByDocumentNumber()
                .collectList()
                .flatMap(cards -> {
                    objectMap.put("cards", cards);
                    return Mono.just(new ResponseEntity<>(objectMap, HttpStatus.OK));
                });
    }

    @GetMapping(value = "/core/cards2")
    public Flux<Card> getCards2() {
        return service.findByDocumentNumber();
    }

    /**
     * @param cardNumber
     * @return getCardsResponse.
     */
    @GetMapping(value = "/core/cards/response")
    public Mono<Card> getCardsResponse(
            @RequestParam(name = "cardNumber") final String cardNumber) {
        return service.findByDocumentNumber()
                .filter(card -> card.getActive() && card.getCardNumber().equals(cardNumber))
                .next()
                .doOnNext(card -> log.info(card.getCardNumber()));
    }
}
