import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
    void whenSecondoRollSpareShoulReturnScoreAsSummOfPreviouseScoreAndDoubleOfSecondRoll() {
        game = new Game();
        game.roll(8);
        game.roll(2);
        assertEquals(8+2*2 ,game.score());
    }

//    @Test
//    void booooo() {
//        game = new Game();
//        game.roll(3);
//        game.roll(4);
//        game.roll(8);
//        game.roll(2);
//        assertEquals(3+4+8+2*2 ,game.score());
//    }




}
