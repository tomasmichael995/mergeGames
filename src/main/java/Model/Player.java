package Model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return getScore() == player.getScore() &&
                getPlayerLeft() == player.getPlayerLeft() &&
                Objects.equals(getUserName(), player.getUserName()) &&
                Objects.equals(getAnswers(), player.getAnswers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getScore(),
                getPlayerLeft(),
                getUserName(),
                getAnswers());
    }
}
