package com.epiuse.poker.deck;

import com.epiuse.poker.card.Card;
import com.epiuse.poker.card.Face;
import com.epiuse.poker.card.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by F4742443 on 2016/03/29.
 * Creates a Deck of cards, Shuffle it and draw the card
 */
public class Deck {

    private final int newSize = 52;
    private List<Card> deck = new ArrayList<Card>(newSize);

    public List<Card> getCardDrawn() {
        return cardDrawn;
    }

    private List<Card> cardDrawn = new ArrayList<Card>(5);

    public Deck() {
        for (Face c : Face.values()) {
            for (Suit s: Suit.values()) {
                Card newCard = new Card(c, s);
                this.deck.add(newCard);
            }
        }

        if (deck.size() != newSize)
            throw new IndexOutOfBoundsException("Deck does not contain 52 cards.");
    }

    public int size() { return this.deck.size(); }

    public String draw() {
        Iterator<Card> itrCard = deck.iterator();

        if (!itrCard.hasNext()) {
            throw new IndexOutOfBoundsException("Deck is empty!");
        }

        Card next = itrCard.next();
        String name = next.getCardDetails();
        this.cardDrawn.add(next);
        this.deck.remove(next);
        return name;
    }

    public void shuffle() {
        Collections.shuffle(this.deck);
    }
}
