package Model;

public final class Player {
    private final long score;
    private final long playerLeft;
    private final String userName;
    private final PlayerAnswers answers;

    public Player(long score, long playerLeft, String userName, PlayerAnswers answers) {
        this.score = score;
        this.playerLeft = playerLeft;
        this.userName = userName;
        this.answers = answers;
    }

    public long getScore() {
        return score;
    }

    public long getPlayerLeft() {
        return playerLeft;
    }

    public String getUserName() {
        return userName;
    }

    public PlayerAnswers getAnswers() {
        return answers;
    }
}
