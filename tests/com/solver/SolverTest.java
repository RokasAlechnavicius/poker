package com.solver;

import com.solver.models.Card;
import com.solver.models.Hand;
import com.solver.solvers.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolverTest {

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

    @Test
    public void testPairSolver() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Card[] cards = getCards("AS TH QS JS TS");
        Card[] cards2 = getCards("AS TH 4D 2C 7S");
        BaseSolver solver1 = getSolver(cards);
        BaseSolver solver2 = getSolver(cards2);
        assertTrue(solver1 instanceof PairSolver);
        assertTrue(solver2 instanceof HighCardSolver);
        assertEquals(BaseSolver.compareValues(solver1, solver2), 1);
    }

    @Test
    public void testPair() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Card[] cards = getCards("AS TH QS JS TS");
        Card[] cards2 = getCards("AS 3H 4D 2C AS");
        BaseSolver solver1 = getSolver(cards);
        BaseSolver solver2 = getSolver(cards2);
        assertTrue(solver1 instanceof PairSolver);
        assertTrue(solver2 instanceof PairSolver);
        assertEquals(BaseSolver.compareValues(solver1, solver2), -1);
    }

    @Test
    public void testPairWithKicker() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Card[] cards = getCards("AS 3H 4D 6C AD");
        Card[] cards2 = getCards("AS 2H 4D 6C AD");
        BaseSolver solver1 = getSolver(cards);
        BaseSolver solver2 = getSolver(cards2);
        assertTrue(solver1 instanceof PairSolver);
        assertTrue(solver2 instanceof PairSolver);
        assertEquals(BaseSolver.compareValues(solver1, solver2), 1);
    }

    @Test
    public void testPairDraw() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Card[] cards = getCards("AS 3S 4D 6S AD");
        Card[] cards2 = getCards("AC 3C 4H 6C AH");
        BaseSolver solver1 = getSolver(cards);
        BaseSolver solver2 = getSolver(cards2);
        assertTrue(solver1 instanceof PairSolver);
        assertTrue(solver2 instanceof PairSolver);
        assertEquals(BaseSolver.compareValues(solver1, solver2), 0);
    }

    @Test
    public void testTwoPairPlayerOneWins() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Card[] cards = getCards("AS 4S 4D 6S AD");
        Card[] cards2 = getCards("AC 4H 4H 2C AH");
        BaseSolver solver1 = getSolver(cards);
        BaseSolver solver2 = getSolver(cards2);
        assertTrue(solver1 instanceof TwoPairSolver);
        assertTrue(solver2 instanceof TwoPairSolver);
        assertEquals(BaseSolver.compareValues(solver1, solver2), 1);
    }

    @Test
    public void testThreeOfAKindPlayerTwoWins() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Card[] cards = getCards("KS 4S KD 6S KH");
        Card[] cards2 = getCards("AC 4H AS 2C AH");
        BaseSolver solver1 = getSolver(cards);
        BaseSolver solver2 = getSolver(cards2);
        assertTrue(solver1 instanceof ThreeOfAKindSolver);
        assertTrue(solver2 instanceof ThreeOfAKindSolver);
        assertEquals(BaseSolver.compareValues(solver1, solver2), -1);
    }

    @Test
    public void TestStraightPlayerTwoWins() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Card[] cards = getCards("2S 4S 3D 5S 6H");
        Card[] cards2 = getCards("6C 7H TS 9C 8H");
        BaseSolver solver1 = getSolver(cards);
        BaseSolver solver2 = getSolver(cards2);
        assertTrue(solver1 instanceof StraightSolver);
        assertTrue(solver2 instanceof StraightSolver);
        assertEquals(BaseSolver.compareValues(solver1, solver2), -1);
    }

    @Test
    public void TestFlushPlayerTwoWins() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Card[] cards = getCards("2S 9S 3S 5S 6S");
        Card[] cards2 = getCards("6S 7S TS KS 8S");
        BaseSolver solver1 = getSolver(cards);
        BaseSolver solver2 = getSolver(cards2);
        assertTrue(solver1 instanceof FlushSolver);
        assertTrue(solver2 instanceof FlushSolver);
        assertEquals(BaseSolver.compareValues(solver1, solver2), -1);
    }

    @Test
    public void TestFourOfAKindPlayerOneWins() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Card[] cards = getCards("KS KH KS AS KD");
        Card[] cards2 = getCards("JS JH JS AD JD");
        BaseSolver solver1 = getSolver(cards);
        BaseSolver solver2 = getSolver(cards2);
        assertTrue(solver1 instanceof FourOfAKindSolver);
        assertTrue(solver2 instanceof FourOfAKindSolver);
        assertEquals(BaseSolver.compareValues(solver1, solver2), 1);
    }

    @Test
    public void testStraightFlushVersusFourOfAKind() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Card[] cards = getCards("6S 7S 8S 9S TS");
        Card[] cards2 = getCards("JS JH JS AD JD");
        BaseSolver solver1 = getSolver(cards);
        BaseSolver solver2 = getSolver(cards2);
        assertTrue(solver1 instanceof StraightFlushSolver);
        assertTrue(solver2 instanceof FourOfAKindSolver);
        assertEquals(BaseSolver.compareValues(solver1, solver2), 1);
    }

    private Card[] getCards(String c) {
        String[] cards = c.split(" ");
        Hand hand = new Hand(cards);
        return hand.getCards();
    }

    private BaseSolver getSolver(Card[] cards) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        for (BaseSolver solver: solvers) {
            if (solver.isOfType(cards)) {
                return solver.newInstance(cards);
            }
            solver.isOfType(cards);
        }
        return new HighCardSolver().newInstance(cards);
    }

}