package com.everis.card.app.service;

import com.everis.card.app.model.Card;
import reactor.core.publisher.Flux;

public interface ICardService {
    /**
     *
     * @return findByDocumentNumber.
     */
    Flux<Card> findByDocumentNumber();
}
