package com.bowling;

import com.bowling.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameTest {

    @Test
    void zeroLancioScoreAzero(){
        Game game = new Game();
        Assertions.assertEquals(0,game.score());
    }
    @Test
    void lancioEabbattoZeroBirilli(){
        Game game = new Game();
        game.roll(0);
        Assertions.assertEquals(0,game.score());
    }
    @Test
    void lancioEabbattoQuattroBirilli(){
        Game game = new Game();
        game.roll(4);
        Assertions.assertEquals(4,game.score());
    }
    @Test
    void lancio_per_piu_frame_senza_fare_ne_spare_o_strike(){
        Game game = new Game();
       // frame 1
        game.roll(4);
        game.roll(5);
        //frame 2
        game.roll(1);
        game.roll(3);
        //frame 3
        game.roll(1);
        game.roll(3);

        Assertions.assertEquals(17,game.score());
    }
    @ParameterizedTest
    @CsvSource({"5,5,4,18","4,4,4,12","0,10,4,18"})
    void lancioDopoAverFattoSpareNelTurnoPrecedente(Integer l1,Integer l2,Integer l3,Integer rs){
        Game game = new Game();
        game.roll(l1);
        game.roll(l2);
        game.roll(l3);
        Assertions.assertEquals(rs,game.score());
    }
    @Test
    void somma_dei_birilli_abbattuti_a_cavallo_tra_2_frame_uguale_a_10_non_va_considerato_come_spare(){
        Game game = new Game();
        //frame 1
        game.roll(3);
        game.roll(6);
        //frame 2
        game.roll(4);
        game.roll(4);
        Assertions.assertEquals(17,game.score());
    }

    @ParameterizedTest
    @CsvSource({"10,2,2,18"})
    void lancioDueVolteDopoAverFattoStrikeNelTurnoPrecedente(Integer l1,Integer l2,Integer l3,Integer rs){
        Game game = new Game();
        game.roll(l1);
        game.roll(l2);
        game.roll(l3);
        Assertions.assertEquals(rs,game.score());
    }
}