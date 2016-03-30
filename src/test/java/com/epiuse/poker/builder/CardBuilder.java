package com.epiuse.poker.builder;

import com.epiuse.poker.card.Card;
import com.epiuse.poker.card.Face;
import com.epiuse.poker.card.Suit;

/**
 * Created by F4742443 on 2016/03/30.
 */
public class CardBuilder {

    private Face face;
    private Suit suit;

    public CardBuilder(Face face, Suit suit) {
        this.face = face;
        this.suit = suit;
    }

    public Card build() {
        return new Card(face, suit);
    }
}
