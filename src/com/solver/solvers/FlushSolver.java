package com.solver.solvers;

import com.solver.enums.HandOutcome;
import com.solver.enums.Suite;
import com.solver.models.Card;

import java.util.Arrays;

public class FlushSolver extends BaseSolver {

    @Override
    public BaseSolver newInstance(Card[] cards) {
        FlushSolver solver = new FlushSolver();
        solver.sortGroupedCards(cards);
        return solver;
    }

    @Override
    public boolean isOfType(Card[] cards) {
        Suite suite = cards[0].getSuite();
        return Arrays.stream(cards).allMatch(card -> card.getSuite().equals(suite));
    }

    @Override
    int getComparatorValue() {
        return HandOutcome.FLUSH.ordinal();
    }
}
