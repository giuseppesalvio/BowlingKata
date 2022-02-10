
public class Game {

    private int score;
    private boolean previousFrameWasAspare;
    private int actualFrameScore;
    private boolean firstRoll;
    private int frame;
    private boolean previousFrameWasAstrike;

    public Game() {
        this.score = 0;
        this.actualFrameScore = 0;
        this.previousFrameWasAspare = false;
        this.firstRoll = true;
        this.frame = 0;
    }

    void roll(int pinnedKnoked) {
        resetFrameScoreIfFirstRoll();
        actualFrameScore += pinnedKnoked;
        score += pinnedKnoked;
        score += getBonus(pinnedKnoked);
        previousFrameWasAspare = isThisASpare();
        firstRoll = !firstRoll;
    }

    private boolean isThisASpare() {
        return actualFrameScore == 10 && !firstRoll;
    }

    private boolean isStrike() {
        return actualFrameScore == 10 && firstRoll;
    }

    private int getBonus(int pinnedKnoked) {
        if (previousFrameWasAspare) {
            previousFrameWasAspare = false;
            return pinnedKnoked;
        }
        if(isStrike()){
            previousFrameWasAstrike = true;
            return 10;
        }
        return 0;
    }

    private void resetFrameScoreIfFirstRoll() {
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
