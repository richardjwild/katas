package bowling;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {

    private final BowlingGame bowlingGame = new BowlingGame();

    @Test
    public void gutterGameScoresZero() {
        rollMany(20, 0);
        assertEquals(0, bowlingGame.calculateScore());
    }

    private void rollMany(int rolls, int pins) {
        for (int i = 0; i < rolls; i++)
            bowlingGame.roll(pins);
    }

    @Test
    public void gameOfAllOnesScoresTwenty() {
        rollMany(20, 1);
        assertEquals(20, bowlingGame.calculateScore());
    }

    @Test
    public void spareDoublesNextRoll() {
        bowlingGame.roll(9);
        bowlingGame.roll(1);
        bowlingGame.roll(1);
        rollMany(17, 0);
        assertEquals(12, bowlingGame.calculateScore());
    }

    @Test
    public void spareMustOccurOnFrameBoundary() {
        bowlingGame.roll(0);
        bowlingGame.roll(9);
        bowlingGame.roll(1);
        bowlingGame.roll(1);
        rollMany(16, 0);
        assertEquals(11, bowlingGame.calculateScore());
    }

    @Test
    public void strikeDoublesNextTwoRolls() {
        bowlingGame.roll(10);
        rollMany(2, 1);
        rollMany(16, 0);
        assertEquals(14, bowlingGame.calculateScore());
    }

    @Test
    public void spareInFinalFrameGivesExtraRoll() {
        rollMany(18, 0);
        bowlingGame.roll(9);
        bowlingGame.roll(1);
        bowlingGame.roll(1);
        assertEquals(12, bowlingGame.calculateScore());
    }

    @Test
    public void strikeInFinalFrameGivesExtraTwoRolls() {
        rollMany(18, 0);
        bowlingGame.roll(10);
        bowlingGame.roll(1);
        bowlingGame.roll(1);
        assertEquals(12, bowlingGame.calculateScore());
    }

    @Test
    public void twoStrikesInFinalFrame() {
        rollMany(18, 0);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(1);
        assertEquals(21, bowlingGame.calculateScore());
    }

    @Test
    public void sampleGame() {
        //
        //  |   X | 7 / | 9 - |   X | - 8 | 8 / | - 6 |   X |   X | X 8 1 |
        //  |     |     |     |     |     |     |     |     |     |       |
        //  | 20  | 39  | 48  | 66  | 74  | 84  | 90  | 120 | 148 | 167   |
        //
        bowlingGame.roll(10);
        bowlingGame.roll(7);
        bowlingGame.roll(3);
        bowlingGame.roll(9);
        bowlingGame.roll(0);
        bowlingGame.roll(10);
        bowlingGame.roll(0);
        bowlingGame.roll(8);
        bowlingGame.roll(8);
        bowlingGame.roll(2);
        bowlingGame.roll(0);
        bowlingGame.roll(6);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(8);
        bowlingGame.roll(1);
        assertEquals(167, bowlingGame.calculateScore());
    }

    @Test
    public void perfectGame() {
        rollMany(12, 10);
        assertEquals(300, bowlingGame.calculateScore());
    }
}
