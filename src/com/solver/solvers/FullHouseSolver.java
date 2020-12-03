package com.solver.solvers;

import com.solver.enums.HandOutcome;
import com.solver.enums.Rank;
import com.solver.models.Card;

import java.util.Map;

public class FullHouseSolver extends BaseSolver {

    @Override
    public BaseSolver newInstance(Card[] cards) {
        FullHouseSolver solver = new FullHouseSolver();
        solver.sortGroupedCards(cards);
        return solver;
    }

    @Override
    public boolean isOfType(Card[] cards) {
        Map<Rank, Long> counted = groupCardsByRank(cards);
        if (counted.size() != 2) {
            return false;
        }
        Long entrySetValue = counted.entrySet().iterator().next().getValue();
        return entrySetValue != 1 && entrySetValue != 4;
    }

    @Override
    int getComparatorValue() {
        return HandOutcome.FULL_HOUSE.ordinal();
    }
}
