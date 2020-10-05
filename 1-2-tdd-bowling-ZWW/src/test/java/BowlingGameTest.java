import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {
    BowlingGame bowlingGame = new BowlingGame();

    @Test
    public void should_return_total_300_when_12_ten_all_strike() {
        int[] input={10,10,10,10,10,10,10,10,10,10,10,10};
        int expected = 300;
        int received = bowlingGame.Bowling(input);
        assertEquals(expected, received);
    }

    @Test
    public void should_return_total_0_when_20_zero_all_miss() {
        int[] input={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int expected = 0;
        int received = bowlingGame.Bowling(input);
        assertEquals(expected, received);
    }

    @Test
    public void should_return_total_when_21_score_all_spare() {
        int[] input={5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5};
        int expected = 110;
        int received = bowlingGame.Bowling(input);
        assertEquals(expected, received);
    }

    @Test
    public void should_return_total_when_frame_result_mixed() {}

}