package com.solver.solvers;

import com.solver.enums.Rank;
import com.solver.models.Card;

import java.util.*;
import java.util.stream.Collectors;

public abstract class BaseSolver {

    protected List<Card> sortedPlayCards = new ArrayList<>();

    public static int compareValues(BaseSolver base1, BaseSolver base2) {
        int base1Value = base1.getComparatorValue();
        int base2Value = base2.getComparatorValue();

        if (base1Value != base2Value) {
            return base1Value > base2Value ? 1 : -1;
        }
        return compareCardsPlay(base1.sortedPlayCards, base2.sortedPlayCards);
    }

    private static int compareCardsPlay(List<Card> cardsPlay1, List<Card> cardsPlay2) {
        for (int i = 0; i < cardsPlay1.size(); i++) {
            if (cardsPlay1.get(i).getRank().ordinal() == cardsPlay2.get(i).getRank().ordinal()) {
                continue;
            }
            return cardsPlay1.get(i).getRank().ordinal() > cardsPlay2.get(i).getRank().ordinal() ? 1 : -1;
        }
        return 0;
    }

    public abstract BaseSolver newInstance(Card[] cards);

    public abstract boolean isOfType(Card[] cards);

    protected boolean isNOfAKind(int n, Card[] cards) {
        Map<Rank, Long> counted = groupCardsByRank(cards);

        return counted.entrySet().stream().anyMatch(x -> x.getValue() == n);
    }

    protected Map<Rank, Long> groupCardsByRank(Card[] cards) {
        return Arrays.stream(cards)
                .collect(Collectors.groupingBy(Card::getRank, Collectors.counting()));
    }

    protected void sortGroupedCards(Card[] cards) {
        Map<Rank, Long> counted = groupCardsByRank(cards);
        Comparator<Map.Entry<Rank, Long>> comparator
                = Map.Entry.<Rank, Long>comparingByValue()
                .thenComparing(Map.Entry.comparingByKey())
                .reversed();

        counted.entrySet().stream().sorted(comparator).forEach(entry -> {
            sortedPlayCards.addAll(
                    Arrays.stream(cards)
                            .filter(x -> x.getRank().equals(entry.getKey()))
                            .collect(Collectors.toList()));
        });
    }

    abstract int getComparatorValue();
}
