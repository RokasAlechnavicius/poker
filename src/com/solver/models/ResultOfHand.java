package com.solver.models;

import com.solver.enums.HandOutcome;
import com.solver.enums.Rank;

public class ResultOfHand {

    private Rank rank;
    private HandOutcome handOutcome;

    public ResultOfHand(Rank rank, HandOutcome handOutcome) {
        this.rank = rank;
        this.handOutcome = handOutcome;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public HandOutcome getHandOutcome() {
        return handOutcome;
    }

    public void setHandOutcome(HandOutcome handOutcome) {
        this.handOutcome = handOutcome;
    }

    @Override
    public String toString() {
        return "ResultOfHand{" +
                "rank=" + rank +
                ", handOutcome=" + handOutcome +
                '}';
    }
}
