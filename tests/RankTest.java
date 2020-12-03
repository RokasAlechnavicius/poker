import com.solver.enums.Rank;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RankTest {

    @Test
    public void testNextRank_Ace() throws Exception {
        Rank ace = Rank.ACE;
        Rank nextRank = Rank.getNextRank(ace);
        assertEquals(nextRank, Rank.TWO);
    }

    @Test
    public void testNextRank_Two() throws Exception {
        Rank ace = Rank.TWO;
        Rank nextRank = Rank.getNextRank(ace);
        assertEquals(nextRank, Rank.THREE);
    }

    @Test
    public void testNextRank_Ten() throws Exception {
        Rank ace = Rank.TEN;
        Rank nextRank = Rank.getNextRank(ace);
        assertEquals(nextRank, Rank.JACK);
    }

    @Test
    public void testNextRank_King() throws Exception {
        Rank ace = Rank.KING;
        Rank nextRank = Rank.getNextRank(ace);
        assertEquals(nextRank, Rank.ACE);
    }

    @Test
    public void testInvalidNextRank_King() throws Exception {
        Rank ace = Rank.KING;
        Rank nextRank = Rank.getNextRank(ace);
        assertNotEquals(nextRank, Rank.QUEEN);
    }

}