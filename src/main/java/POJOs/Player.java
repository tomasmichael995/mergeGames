package POJOs;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private final int score;
    private final int playerLeft;
    private final String userName;
    private final PlayerAnswers answers;

    public Player(int score, int playerLeft, String userName, PlayerAnswers answers) {
        this.score = score;
        this.playerLeft = playerLeft;
        this.userName = userName;
        this.answers = answers;
    }

    public int getScore() {
        return score;
    }

    public int getPlayerLeft() {
        return playerLeft;
    }

    public String getUserName() {
        return userName;
    }

    public PlayerAnswers getAnswers() {
        return answers;
    }
}
