package com.bowling;

public class Game {
    private int birilliHitOnPreviousRoll;
    private boolean isSecondRollOfCurrentFrame;
    private boolean isSpareOnPreviousFrame;
    private int score=0;

//10 | --> 2--> 2 |

    // |3-->6 | 4 --> 4 |
    void roll(int numBirilli) {

        if (isSpareOnPreviousFrame) {
            score = score + numBirilli + numBirilli;
            isSpareOnPreviousFrame = false;
        }
        else if (birilliHitOnPreviousRoll +numBirilli != 10){
            score = score + numBirilli;
            birilliHitOnPreviousRoll = numBirilli;
            isSpareOnPreviousFrame = false;
            isSecondRollOfCurrentFrame = !isSecondRollOfCurrentFrame;
        } else if (birilliHitOnPreviousRoll +numBirilli == 10) {
            isSpareOnPreviousFrame = true;
            score = score + numBirilli;
            birilliHitOnPreviousRoll = 0;
            isSecondRollOfCurrentFrame = !isSecondRollOfCurrentFrame;
        }

    }

    int score() {
        return score;
    }
}
