package com.solver.solvers;

import com.solver.enums.HandOutcome;
import com.solver.enums.Suite;
import com.solver.models.Card;

import java.util.Arrays;

public class StraightFlushSolver extends StraightSolver {

    @Override
    public BaseSolver newInstance(Card[] cards) {
        StraightFlushSolver solver = new StraightFlushSolver();
        solver.sortGroupedCards(cards);
        return solver;
    }

    @Override
    public boolean isOfType(Card[] cards) {
        Suite suite = cards[0].getSuite();
        return super.isOfType(cards) &&
                Arrays.stream(cards).allMatch(card -> card.getSuite().equals(suite));

    }

    @Override
    int getComparatorValue() {
        return HandOutcome.STRAIGHT_FLUSH.ordinal();
    }
}
