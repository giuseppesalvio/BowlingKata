
public class Game {

    private int score;
    private boolean firstRoll;

    public Game() {
        this.score = 0;
        this.firstRoll = true;
    }

    void roll(int pinnedKnoked) {
        score = score + pinnedKnoked;
        if (!firstRoll && score == 10) {
            score = score + pinnedKnoked;
        }
        firstRoll = !firstRoll;
    }

    int score() {
        return score;
    }

}
