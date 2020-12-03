package com.solver.solvers;

import com.solver.enums.HandOutcome;
import com.solver.models.Card;

public class StraightSolver extends BaseSolver {

    @Override
    public BaseSolver newInstance(Card[] cards) {
        StraightSolver solver = new StraightSolver();
        solver.sortGroupedCards(cards);
        return solver;
    }

    @Override
    public boolean isOfType(Card[] cards) {
        for (int i = 0; i < cards.length - 1; i++) {
            if (cards[i].getRank().getNextRank() != cards[i + 1].getRank()) {
                return false;
            }
        }
        return true;
    }

    @Override
    int getComparatorValue() {
        return HandOutcome.STRAIGHT.ordinal();
    }
}
