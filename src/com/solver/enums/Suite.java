package com.solver.enums;

public enum Suite {
    HEARTS('H'),
    CLUBS('C'),
    SPADES('S'),
    DIAMONDS('D');

    public final char label;

    private Suite(char label) {
        this.label = label;
    }

    public static Suite valueOfLabel(char label) {
        for (Suite e : values()) {
            if (e.label == label) {
                return e;
            }
        }
        return null;
    }

}
