package com.everis.card.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    /**
     * field cardNumber.
     */
    private String cardNumber;
    /**
     * active.
     */
    private Boolean active;
}
