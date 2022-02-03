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
    @ParameterizedTest
    @CsvSource({"5,5,4,18","4,4,4,12","0,10,4,18"})
    void spareTreTiriConsecutivi(Integer l1,Integer l2,Integer l3,Integer rs){
        Game game = new Game();
        game.roll(l1);
        game.roll(l2);
        game.roll(l3);
        Assertions.assertEquals(rs,game.score());
    }
    @ParameterizedTest
    @CsvSource({"10,2,2,18"})
    void StrakeTreTiriConsecutivi(Integer l1,Integer l2,Integer l3,Integer rs){
        Game game = new Game();
        game.roll(l1);
        game.roll(l2);
        game.roll(l3);
        Assertions.assertEquals(rs,game.score());
    }
}