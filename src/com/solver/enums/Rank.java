package com.solver.enums;

public enum Rank {
    TWO('2'),
    THREE('3'),
    FOUR('4'),
    FIVE('5'),
    SIX('6'),
    SEVEN('7'),
    EIGHT('8'),
    NINE('9'),
    TEN('T'),
    JACK('J'),
    QUEEN('Q'),
    KING('K'),
    ACE('A');

    public final char label;

    Rank(char label) {
        this.label = label;
    }

    public static Rank getNextRank(Rank rank) {
        return Rank.values()[(rank.ordinal() + 1) % values().length];
    }

    public static Rank valueOfLabel(char label) {
        for (Rank e : values()) {
            if (e.label == label) {
                return e;
            }
        }
        return null;
    }

    public Rank getNextRank() {
        return getNextRank(this);
    }
}
