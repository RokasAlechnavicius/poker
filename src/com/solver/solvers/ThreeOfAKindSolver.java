package com.solver.solvers;

import com.solver.enums.HandOutcome;
import com.solver.models.Card;

public class ThreeOfAKindSolver extends BaseSolver {

    @Override
    public BaseSolver newInstance(Card[] cards) {
        ThreeOfAKindSolver solver = new ThreeOfAKindSolver();
        solver.sortGroupedCards(cards);
        return solver;
    }

    @Override
    public boolean isOfType(Card[] cards) {
        return isNOfAKind(3, cards);
    }

    @Override
    int getComparatorValue() {
        return HandOutcome.THREE_OF_A_KIND.ordinal();
    }
}
