
public class Game {

    private int score;
    private boolean spare;
    private int actualFrameScore;
    private boolean firstRoll;
    private int frame;
    private boolean previousRollWasAstrike;

    public Game() {
        this.score = 0;
        this.actualFrameScore = 0;
        this.spare = false;
        this.firstRoll = true;
        this.frame = 0;
    }

    void roll(int pinnedKnoked) {
        sePrimoTiro();
        actualFrameScore += pinnedKnoked;
        score += pinnedKnoked;
        score += getBonus(pinnedKnoked);
        spare = isSpare();
        firstRoll = !firstRoll;
    }

    private boolean isSpare() {
        return actualFrameScore == 10 && !firstRoll;
    }

    private boolean isStrike() {
        return actualFrameScore == 10 && firstRoll;
    }

    private int getBonus(int pinnedKnoked) {
        if (spare) {
            spare = false;
            return pinnedKnoked;
        }
        if(isStrike()){
            previousRollWasAstrike = true;
            return 10;
        }
        return 0;
    }

    private void sePrimoTiro() {
        if (firstRoll) {
            actualFrameScore = 0;
        }
    }

    int score() {
        return score;
    }

    public int getActualFrameScore() {
        return actualFrameScore;
    }
}
