package com.solver.solvers;

import com.solver.enums.HandOutcome;
import com.solver.enums.Rank;
import com.solver.models.Card;

import java.util.Arrays;

public class RoyalFlushSolver extends StraightFlushSolver {

    @Override
    public BaseSolver newInstance(Card[] cards) {
        RoyalFlushSolver solver = new RoyalFlushSolver();
        solver.sortGroupedCards(cards);
        return solver;
    }

    @Override
    public boolean isOfType(Card[] cards) {
        return super.isOfType(cards) &&
                Arrays.stream(cards).allMatch(card -> card.getRank().ordinal() > Rank.NINE.ordinal());

    }

    @Override
    int getComparatorValue() {
        return HandOutcome.ROYAL_FLUSH.ordinal();
    }
}
