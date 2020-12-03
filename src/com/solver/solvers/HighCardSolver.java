package com.solver.solvers;

import com.solver.enums.HandOutcome;
import com.solver.models.Card;

public class HighCardSolver extends BaseSolver {


    @Override
    public BaseSolver newInstance(Card[] cards) {
        HighCardSolver solver = new HighCardSolver();
        solver.sortGroupedCards(cards);
        return solver;
    }

    @Override
    public boolean isOfType(Card[] cards) {
        return true;
    }

    @Override
    int getComparatorValue() {
        return HandOutcome.H_CARD.ordinal();
    }
}
