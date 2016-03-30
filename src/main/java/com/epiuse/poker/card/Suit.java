package com.epiuse.poker.card;

/**
 * Created by F4742443 on 2016/03/29.
 * Represents the Suits for Card
 */
public enum Suit {

    HEART(1,'\u2764'), DIAMOND(2,'\u2666'), CLUB(3,'\u2663'), SPADE(4,'\u2660');

    public int getKey() {
        return key;
    }

    private int key;
    private char name;

    Suit(int key,char name) {
        this.key = key;
        this.name = name;
    }

    String getSuitSymbol() {
        return String.valueOf(this.name);
    }
}
