package com.epiuse.poker.main;

import com.epiuse.poker.card.Card;
import com.epiuse.poker.deck.Deck;
import com.epiuse.poker.util.PokerHandUtil;

import java.util.List;

/**
 * Created by F4742443 on 2016/03/29.
 * Main Class to be used to run the draw
 */
public class Main {


    public static void main(String[] args) {

        Deck deck = new Deck();

        System.out.println("Shuffling... Shuffling... Shuffling...");

        deck.shuffle();

        System.out.println("The deck is now shuffled.");

        System.out.print("Your Hand: ");

        /* ---------------------------------------------
       Drawing each card one by one from the Deck
       --------------------------------------------- */
        for (int i = 0; i < 5; i++) {
            System.out.print(deck.draw() + " ");
        }
        System.out.println(" ");

        List<Card> cardsDrawn = deck.getCardDrawn();

        Card[] cards = cardsDrawn.toArray(new Card[cardsDrawn.size()]);

        System.out.println(PokerHandUtil.valueHand(cards));

    }
}
