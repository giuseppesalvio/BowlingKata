package com.bowling;

public class Game {
    private int birilliHitOnPreviousRoll;
    private int birilliHitOnPreviousRollOfCurrentFrame;
    private boolean isSecondRollOfCurrentFrame;
    private boolean isSpareOnPreviousFrame;
    private boolean isStrikeOnPreviousFrame;
    private int score=0;

    public Game() {
        this.birilliHitOnPreviousRoll=0;
    }

    // |3-->6 | 4 --> 4 |
    void roll(int numBirilli) {
        if(numBirilli==10)
            isStrikeOnPreviousFrame=true;
        if (isSpareOnPreviousFrame) {
            score = score + numBirilli + numBirilli;
            isSpareOnPreviousFrame = false;
        }

        else if (hoFattoSpareInCurrentFrame(numBirilli)) {
            isSpareOnPreviousFrame = true;
            score = score + numBirilli;
            isSecondRollOfCurrentFrame = false;
            birilliHitOnPreviousRoll = 0;
        }
        else{
            score = score + numBirilli;
            birilliHitOnPreviousRoll = numBirilli;
            isSecondRollOfCurrentFrame = !isSecondRollOfCurrentFrame;
        }
    }

    int score() {
        return score;
    }

    private boolean hoFattoSpareInCurrentFrame(int numBirilli) {
        return isSecondRollOfCurrentFrame && birilliHitOnPreviousRoll + numBirilli == 10;
    }

}
