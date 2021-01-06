package com.everis.card.app.service.impl;

import com.everis.card.app.model.Card;
import com.everis.card.app.service.ICardService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CardServiceImpl implements ICardService {
    /**
     *
     * @return findByDocumentNumber.
     */
    @Override
    public Flux<Card> findByDocumentNumber() {
        return Flux.just(
                new Card("5527023119095755", true),
                new Card("5267072725200626", true),
                new Card("5147562525936540", true),
                new Card("5506866514995358", false),
                new Card("5376448345016758", false),
                new Card("5580737355430608", false)
        );
    }
}
