package com.epiuse.poker.card;

/**
 * Created by F4742443 on 2016/03/29.
 * Represents the Face of the cards
 */
public enum Face {

    ACE(13,"A"), TWO(1, "2"), THREE(2, "3"), FOUR(3, "4"),
    FIVE(4, "5"), SIX(5, "6"), SEVEN(6, "7"), EIGHT(7, "8"),
    NINE(8 , "9"), TEN(9, "10"), JACK(10, "J"), QUEEN(11, "Q"), KING(12,"K");

    private final int rank;
    private final String name;

    Face(int rank, String name) {
        this.name = name;
        this.rank = rank;
    }

    String getFaceName() {
        return this.name;
    }

    public int getRank() {
        return rank;
    }
}
