import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    private Game game;

    @Test
    void createGame() {
        game = new Game();
        assertEquals(0 ,game.score());
    }

    @Test
    void whenFirsRollShouldReturnScoreAsPinnedKnoked() {
        game = new Game();
        game.roll(9);
        assertEquals(9 ,game.score());
    }

    @Test
    void whenSecondoRollShoulReturnScoreAsSummOfPinnedKnokedAndPreviouseScore() {
        game = new Game();
        game.roll(4);
        game.roll(3);
        assertEquals(4+3 ,game.score());
    }

    @Test
    void whenSpareFirstFrame() {
        game = new Game();
        game.roll(8);
        game.roll(2);
        game.roll(3);
        assertEquals(8+2+3+3 ,game.score());
    }


    @Test
    void whenSpareInSecondFrame() {
        game = new Game();
        game.roll(1);
        game.roll(1);
        assertEquals(1+1 ,game.getActualFrameScore());
        game.roll(8);
        game.roll(2);
        assertEquals(8+2 ,game.getActualFrameScore());
        game.roll(3);
        game.roll(4);
        assertEquals(3+4 ,game.getActualFrameScore());
        assertEquals(1+1+8+2+3+3+4 ,game.score());
    }


    @Test
    void whenStrikeFirstFrame() {
        game = new Game();
        game.roll(10);
        game.roll(3);
        game.roll(4);
        assertEquals(10+ 3+4 + 3+4 ,game.score());
    }


}
