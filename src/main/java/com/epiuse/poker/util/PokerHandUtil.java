package com.epiuse.poker.util;

import com.epiuse.poker.card.Card;

/**
 * Created by F4742443 on 2016/03/30.
 * Methods used to determine a certain Poker hand
 */
public class PokerHandUtil {

    /* ---------------------------------------------
       isFlush(): true if cards has a flush
                  false otherwise
       --------------------------------------------- */
    public static boolean isFlush(Card[] cards) {
        if (cards.length != 5)
            return (false);

        sortBySuit(cards);

        return (cards[0].getSuit() == cards[4].getSuit());   // All cards has same suit
    }

    /* ---------------------------------------------
       Sort hand by suit:

           smallest suit card first ....

       (Finding a flush is easier that way)
       --------------------------------------------- */
    public static void sortBySuit(Card[] cards) {
        int i, j, min_j;

      /* ---------------------------------------------------
         The selection sort algorithm
         --------------------------------------------------- */
        for (i = 0; i < cards.length; i++) {
         /* ---------------------------------------------------
            Find array element with min. value among
            cards[i], cards[i+1], ..., cards[n-1]
            --------------------------------------------------- */
            min_j = i;   // Assume elem i (cards[i]) is the minimum

            for (j = i + 1; j < cards.length; j++) {
                if (cards[j].getSuit().getKey() < cards[min_j].getSuit().getKey()) {
                    min_j = j;    // We found a smaller minimum, update min_j
                }
            }

         /* ---------------------------------------------------
            Swap a[i] and a[min_j]
            --------------------------------------------------- */
            Card help = cards[i];
            cards[i] = cards[min_j];
            cards[min_j] = help;
        }
    }

    /* ---------------------------------------------
       isStraight(): true if cards is a Straight
                     false otherwise
       --------------------------------------------- */
    public static boolean isStraight(Card[] cards) {
        int i, testRank;

        if (cards.length != 5)
            return (false);

        sortByRank(cards);

      /* ===========================
         Check if hand has an Ace
         =========================== */
        if (cards[4].getCardFace().getRank() == 13) {
         /* =================================
            Check straight using an Ace
            ================================= */
            boolean a = cards[0].getCardFace().getRank() == 1 && cards[1].getCardFace().getRank() == 2 &&
                    cards[2].getCardFace().getRank() == 3 && cards[3].getCardFace().getRank() == 4;
            boolean b = cards[0].getCardFace().getRank() == 9 && cards[1].getCardFace().getRank() == 10 &&
                    cards[2].getCardFace().getRank() == 11 && cards[3].getCardFace().getRank() == 12;

            return (a || b);
        } else {
         /* ===========================================
            General case: check for increasing values
            =========================================== */
            testRank = cards[0].getCardFace().getRank() + 1;

            for (i = 1; i < 5; i++) {
                if (cards[i].getCardFace().getRank() != testRank)
                    return (false);        // Straight failed...

                testRank++;
            }

            return (true);        // Straight found !
        }
    }

     /* ===========================================================
      Helper methods
      =========================================================== */

    /* ---------------------------------------------
       Sort hand by rank:

           smallest ranked card first ....

       (Finding a straight is eaiser that way)
       --------------------------------------------- */
    public static void sortByRank(Card[] cards) {
        int i, j, min_j;

      /* ---------------------------------------------------
         The selection sort algorithm
         --------------------------------------------------- */
        for (i = 0; i < cards.length; i++) {
         /* ---------------------------------------------------
            Find array element with min. value among
            cards[i], cards[i+1], ..., cards[n-1]
            --------------------------------------------------- */
            min_j = i;   // Assume elem i (cards[i]) is the minimum

            for (j = i + 1; j < cards.length; j++) {
                if (cards[j].getCardFace().getRank() < cards[min_j].getCardFace().getRank()) {
                    min_j = j;    // We found a smaller minimum, update min_j
                }
            }

         /* ---------------------------------------------------
            Swap a[i] and a[min_j]
            --------------------------------------------------- */
            Card help = cards[i];
            cards[i] = cards[min_j];
            cards[min_j] = help;
        }
    }


    /* ---------------------------------------------
       isFourOfAKind(): true if cards has 4 of a kind
               false otherwise
       --------------------------------------------- */
    public static boolean isFourOfAKind(Card[] cards) {
        boolean a1, a2;

        if (cards.length != 5)
            return (false);

        sortByRank(cards);

        a1 = cards[0].getCardFace().getRank() == cards[1].getCardFace().getRank() &&
                cards[1].getCardFace().getRank() == cards[2].getCardFace().getRank() &&
                cards[2].getCardFace().getRank() == cards[3].getCardFace().getRank();

        a2 = cards[1].getCardFace().getRank() == cards[2].getCardFace().getRank() &&
                cards[2].getCardFace().getRank() == cards[3].getCardFace().getRank() &&
                cards[3].getCardFace().getRank() == cards[4].getCardFace().getRank();

        return (a1 || a2);
    }


    /* ----------------------------------------------------
       isFullHouse(): true if cards has Full House
                      false otherwise
       ---------------------------------------------------- */
    public static boolean isFullHouse(Card[] cards) {
        boolean a1, a2;

        if (cards.length != 5)
            return (false);

        sortByRank(cards);

        a1 = cards[0].getCardFace().getRank() == cards[1].getCardFace().getRank() &&  //  x x x y y
                cards[1].getCardFace().getRank() == cards[2].getCardFace().getRank() &&
                cards[3].getCardFace().getRank() == cards[4].getCardFace().getRank();

        a2 = cards[0].getCardFace().getRank() == cards[1].getCardFace().getRank() &&  //  x x y y y
                cards[2].getCardFace().getRank() == cards[3].getCardFace().getRank() &&
                cards[3].getCardFace().getRank() == cards[4].getCardFace().getRank();

        return (a1 || a2);
    }


    /* ----------------------------------------------------
       isThreeOfAKind(): true if cards has 3 of a kind
               false otherwise

       **** Note: use isThreeOfAKind() ONLY if you know the hand
                  does not have 4 of a kind
       ---------------------------------------------------- */
    public static boolean isThreeOfAKind(Card[] cards) {
        boolean a1, a2, a3;

        if (cards.length != 5)
            return (false);

        if (isFourOfAKind(cards) || isFullHouse(cards))
            return (false);        // The hand is not 3 of a kind (but better)

      /* ----------------------------------------------------------
         Now we know the hand is not 4 of a kind or a full house !
         ---------------------------------------------------------- */
        sortByRank(cards);

        a1 = cards[0].getCardFace().getRank() == cards[1].getCardFace().getRank() &&
                cards[1].getCardFace().getRank() == cards[2].getCardFace().getRank();

        a2 = cards[1].getCardFace().getRank() == cards[2].getCardFace().getRank() &&
                cards[2].getCardFace().getRank() == cards[3].getCardFace().getRank();

        a3 = cards[2].getCardFace().getRank() == cards[3].getCardFace().getRank() &&
                cards[3].getCardFace().getRank() == cards[4].getCardFace().getRank();

        return (a1 || a2 || a3);
    }

    /* -----------------------------------------------------
       is22s(): true if cards has 2 pairs
                false otherwise

       **** Note: use isTwoPair() ONLY if you know the hand
                  does not have 3 of a kind or better
       ----------------------------------------------------- */
    public static boolean isTwoPair(Card[] cards) {
        boolean a1, a2, a3;

        if (cards.length != 5)
            return (false);

        if (isFourOfAKind(cards) || isFullHouse(cards) || isThreeOfAKind(cards))
            return (false);        // The hand is not 2 pairs (but better)

        sortByRank(cards);

        a1 = cards[0].getCardFace().getRank() == cards[1].getCardFace().getRank() &&
                cards[2].getCardFace().getRank() == cards[3].getCardFace().getRank();

        a2 = cards[0].getCardFace().getRank() == cards[1].getCardFace().getRank() &&
                cards[3].getCardFace().getRank() == cards[4].getCardFace().getRank();

        a3 = cards[1].getCardFace().getRank() == cards[2].getCardFace().getRank() &&
                cards[3].getCardFace().getRank() == cards[4].getCardFace().getRank();

        return (a1 || a2 || a3);
    }


    /* -----------------------------------------------------
       isOnePair(): true if cards has one pair
               false otherwise

       **** Note: use isOnePair() ONLY if you know the hand
                  does not have 2 pairs or better
       ----------------------------------------------------- */
    public static boolean isOnePair(Card[] cards) {
        boolean a1, a2, a3, a4;

        if (cards.length != 5)
            return (false);

        if (isFourOfAKind(cards) || isFullHouse(cards) || isThreeOfAKind(cards) || isTwoPair(cards))
            return (false);        // The hand is not one pair (but better)

        sortByRank(cards);

        a1 = cards[0].getCardFace().getRank() == cards[1].getCardFace().getRank();
        a2 = cards[1].getCardFace().getRank() == cards[2].getCardFace().getRank();
        a3 = cards[2].getCardFace().getRank() == cards[3].getCardFace().getRank();
        a4 = cards[3].getCardFace().getRank() == cards[4].getCardFace().getRank();

        return (a1 || a2 || a3 || a4);
    }

    /* --------------------------------------------------------
      valueHand(): return value of a hand
      -------------------------------------------------------- */

    public static String valueHand(Card[] cards) {
        if (isFlush(cards) && isStraight(cards))
            return "Your Have: Straight Flush ";
        else if (isFourOfAKind(cards))
            return "You Have: Four of a Kind";
        else if (isFullHouse(cards))
            return "You Have: Full House";
        else if (isFlush(cards))
            return "You Have: Flush";
        else if (isStraight(cards))
            return "You Have: Straight";
        else if (isThreeOfAKind(cards))
            return "You Have: Three of a Kind";
        else if (isTwoPair(cards))
            return "You Have: Two pair";
        else if (isOnePair(cards))
            return "You Have: One Pair";
        else
            return "You Have: High Cards";
    }
}


