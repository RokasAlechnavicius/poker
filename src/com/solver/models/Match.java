package com.solver.models;

import com.solver.solvers.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class Match {

    private static final List<BaseSolver> solvers = Arrays.asList(
            new RoyalFlushSolver(),
            new StraightFlushSolver(),
            new FourOfAKindSolver(),
            new FullHouseSolver(),
            new FlushSolver(),
            new StraightSolver(),
            new ThreeOfAKindSolver(),
            new TwoPairSolver(),
            new PairSolver(),
            new HighCardSolver()
    );
    public final Hand playerOneHand;
    public final Hand playerTwoHand;

    public Match(Hand playerOneHand, Hand playerTwoHand) {
        this.playerOneHand = playerOneHand;
        this.playerTwoHand = playerTwoHand;
    }

    private BaseSolver getSolver(Card[] cards) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        for (BaseSolver solver : solvers) {
            if (solver.isOfType(cards)) {
                return solver.newInstance(cards);
            }
            solver.isOfType(cards);
        }
        return new HighCardSolver().newInstance(cards);
    }

    public int didPlayerOneWin() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        BaseSolver solverPlayerOne = getSolver(playerOneHand.getCards());
        BaseSolver solverPlayerTwo = getSolver(playerTwoHand.getCards());
        return BaseSolver.compareValues(solverPlayerOne, solverPlayerTwo);
    }
}
