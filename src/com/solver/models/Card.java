package com.solver.models;

import com.solver.enums.Rank;
import com.solver.enums.Suite;

public class Card implements Comparable<Card> {

    private Suite suite;
    private Rank rank;

    public Card(Rank rank, Suite suite) {
        this.suite = suite;
        this.rank = rank;
    }

    public Suite getSuite() {
        return suite;
    }

    public void setSuite(Suite suite) {
        this.suite = suite;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public int getOrdinal() {
        return this.rank.ordinal();
    }

    @Override
    public int compareTo(Card other) {
        return rank.compareTo(other.rank);
    }

    @Override
    public String toString() {
        return "Card{" +
                "suite=" + suite +
                ", rank=" + rank +
                '}';
    }
}
