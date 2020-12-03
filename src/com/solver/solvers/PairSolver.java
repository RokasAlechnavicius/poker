package com.solver.solvers;

import com.solver.enums.HandOutcome;
import com.solver.models.Card;

public class PairSolver extends BaseSolver {

    @Override
    public BaseSolver newInstance(Card[] cards) {
        PairSolver solver = new PairSolver();
        solver.sortGroupedCards(cards);
        return solver;
    }

    @Override
    public boolean isOfType(Card[] cards) {
        return isNOfAKind(2, cards);
    }

    @Override
    int getComparatorValue() {
        return HandOutcome.PAIR.ordinal();
    }
}
