package com.solver.models;

import com.solver.enums.Rank;
import com.solver.enums.Suite;

import java.util.Arrays;

public class Hand {

    private final Card[] cards;

    public Hand(String[] strCards) {
        this.cards = new Card[5];
        for (int i = 0; i < 5; i++)
            cards[i] = new Card(Rank.valueOfLabel(strCards[i].charAt(0)), Suite.valueOfLabel(strCards[i].charAt(1)));
        Arrays.sort(cards);
    }

    @Override
    public String toString() {
        return cards[0].toString() + " " +
                cards[1].toString() + " " +
                cards[2].toString() + " " +
                cards[3].toString() + " " +
                cards[4].toString() + " ";
    }

    public Card[] getCards() {
        return cards;
    }
}
