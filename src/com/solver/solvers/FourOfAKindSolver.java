package com.solver.solvers;

import com.solver.enums.HandOutcome;
import com.solver.models.Card;

public class FourOfAKindSolver extends BaseSolver {

    @Override
    public BaseSolver newInstance(Card[] cards) {
        FourOfAKindSolver solver = new FourOfAKindSolver();
        solver.sortGroupedCards(cards);
        return solver;
    }

    @Override
    public boolean isOfType(Card[] cards) {
        return isNOfAKind(4, cards);
    }

    @Override
    int getComparatorValue() {
        return HandOutcome.FOUR_OF_A_KIND.ordinal();
    }
}
