package com.epiuse.poker.util;

import com.epiuse.poker.builder.CardBuilder;
import com.epiuse.poker.card.Card;
import com.epiuse.poker.card.Face;
import com.epiuse.poker.card.Suit;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by F4742443 on 2016/03/30.
 * Tests for Poker Hands Result
 */
public class PokerHandUtilTest {

    @Test
    public void testIsFlush() throws Exception {
        Card[] cards = new Card[5];
        cards[0] = new CardBuilder(Face.EIGHT, Suit.CLUB).build();
        cards[1] = new CardBuilder(Face.ACE, Suit.CLUB).build();
        cards[2] = new CardBuilder(Face.JACK, Suit.CLUB).build();
        cards[3] = new CardBuilder(Face.QUEEN, Suit.CLUB).build();
        cards[4] = new CardBuilder(Face.FIVE, Suit.CLUB).build();

        assertTrue(PokerHandUtil.isFlush(cards));
    }


    @Test
    public void testIsStraight() throws Exception {
        Card[] cards = new Card[5];
        cards[0] = new CardBuilder(Face.NINE, Suit.CLUB).build();
        cards[1] = new CardBuilder(Face.TEN, Suit.CLUB).build();
        cards[2] = new CardBuilder(Face.JACK, Suit.CLUB).build();
        cards[3] = new CardBuilder(Face.QUEEN, Suit.CLUB).build();
        cards[4] = new CardBuilder(Face.KING, Suit.CLUB).build();

        assertTrue(PokerHandUtil.isStraight(cards));
    }

    @Test
    public void testIsFourOfAKind() throws Exception {

        Card[] cards = new Card[5];
        cards[0] = new CardBuilder(Face.NINE, Suit.CLUB).build();
        cards[1] = new CardBuilder(Face.NINE, Suit.HEART).build();
        cards[2] = new CardBuilder(Face.JACK, Suit.CLUB).build();
        cards[3] = new CardBuilder(Face.NINE, Suit.DIAMOND).build();
        cards[4] = new CardBuilder(Face.NINE, Suit.SPADE).build();

        assertTrue(PokerHandUtil.isFourOfAKind(cards));

    }

    @Test
    public void testIsFullHouse() throws Exception {

        Card[] cards = new Card[5];
        cards[0] = new CardBuilder(Face.NINE, Suit.CLUB).build();
        cards[1] = new CardBuilder(Face.NINE, Suit.HEART).build();
        cards[2] = new CardBuilder(Face.JACK, Suit.CLUB).build();
        cards[3] = new CardBuilder(Face.NINE, Suit.DIAMOND).build();
        cards[4] = new CardBuilder(Face.JACK, Suit.SPADE).build();

        assertTrue(PokerHandUtil.isFullHouse(cards));

    }

    @Test
    public void testIsThreeOfAKind() throws Exception {
        Card[] cards = new Card[5];
        cards[0] = new CardBuilder(Face.NINE, Suit.CLUB).build();
        cards[1] = new CardBuilder(Face.NINE, Suit.HEART).build();
        cards[2] = new CardBuilder(Face.TEN, Suit.CLUB).build();
        cards[3] = new CardBuilder(Face.NINE, Suit.DIAMOND).build();
        cards[4] = new CardBuilder(Face.JACK, Suit.SPADE).build();

        assertTrue(PokerHandUtil.isThreeOfAKind(cards));

    }

    @Test
    public void testIsTwoPair() throws Exception {
        Card[] cards = new Card[5];
        cards[0] = new CardBuilder(Face.NINE, Suit.CLUB).build();
        cards[1] = new CardBuilder(Face.NINE, Suit.HEART).build();
        cards[2] = new CardBuilder(Face.TEN, Suit.CLUB).build();
        cards[3] = new CardBuilder(Face.TEN, Suit.DIAMOND).build();
        cards[4] = new CardBuilder(Face.JACK, Suit.SPADE).build();

        assertTrue(PokerHandUtil.isTwoPair(cards));

    }

    @Test
    public void testIsOnePair() throws Exception {
        Card[] cards = new Card[5];
        cards[0] = new CardBuilder(Face.NINE, Suit.CLUB).build();
        cards[1] = new CardBuilder(Face.NINE, Suit.HEART).build();
        cards[2] = new CardBuilder(Face.EIGHT, Suit.CLUB).build();
        cards[3] = new CardBuilder(Face.TWO, Suit.DIAMOND).build();
        cards[4] = new CardBuilder(Face.JACK, Suit.SPADE).build();

        assertTrue(PokerHandUtil.isOnePair(cards));

    }
}