package com.bowling;

public class Game {
    private int numeroBirilliTurnoPrec;
    private boolean secondoTiro;
    private boolean spare;
    private int score=0;


    void roll(int numBirilli) {

       // 3 7 --> 4
        if (spare) { //3
            score = score + numBirilli + numBirilli;
            spare = false;
        }
        else if (numeroBirilliTurnoPrec +numBirilli != 10){ //1
            score = score + numBirilli;
            numeroBirilliTurnoPrec = numBirilli;
            spare = false;
            secondoTiro = !secondoTiro;
        } else if (numeroBirilliTurnoPrec +numBirilli == 10) { //2
            spare = true;
            score = score + numBirilli;
            numeroBirilliTurnoPrec = 0;
            secondoTiro = !secondoTiro;
        }

    }

    int score() {
        return score;
    }
}
