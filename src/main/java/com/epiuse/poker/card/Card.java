package com.epiuse.poker.card;

/**
 * Created by F4742443 on 2016/03/29.
 * Representation of a Card
 */
public class Card {

    private Face cardFace;
    private Suit suit;

    public Card(Face cardFace, Suit suit) {
        this.cardFace = cardFace;
        this.suit = suit;
    }

    public String getCardDetails() {
        return cardFace.getFaceName() + suit.getSuitSymbol();
    }

    public Face getCardFace() { return cardFace; }

    public Suit getSuit() { return suit; }
}
