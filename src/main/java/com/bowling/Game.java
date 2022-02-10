package com.bowling;

public class Game {
    private int birilliHitOnPreviousRoll;
    private int birilliHitOnPreviousRollOfCurrentFrame;
    private boolean isSecondRollOfCurrentFrame;
    private boolean isSpareOnPreviousFrame;
    private int score=0;

    public Game() {
        this.birilliHitOnPreviousRoll=0;
    }

//10 | --> 2--> 2 |

    // |3-->6 | 4 --> 4 |
    void roll(int numBirilli) {
        if (isSpareOnPreviousFrame) {
            score = score + numBirilli + numBirilli;
            isSpareOnPreviousFrame = false;
        }
        else if (isSecondRollOfCurrentFrame && birilliHitOnPreviousRoll + numBirilli == 10) {
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
}
