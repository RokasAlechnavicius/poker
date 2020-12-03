package com.solver.solvers;

import com.solver.enums.HandOutcome;
import com.solver.enums.Rank;
import com.solver.models.Card;

import java.util.Map;

public class TwoPairSolver extends BaseSolver {

    @Override
    public BaseSolver newInstance(Card[] cards) {
        TwoPairSolver solver = new TwoPairSolver();
        solver.sortGroupedCards(cards);
        return solver;
    }

    @Override
    public boolean isOfType(Card[] cards) {
        Map<Rank, Long> counted = groupCardsByRank(cards);
        return counted.entrySet().stream().filter(x -> x.getValue() == 2).count() == 2;
    }

    @Override
    int getComparatorValue() {
        return HandOutcome.TWO_PAIR.ordinal();
    }
}
