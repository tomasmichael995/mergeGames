package Model;

import java.util.Objects;

public final class GameRound {
    private final long id;
    private final long points;
    private final String gameId;
    private final String createdAt;
    private final Player player1, player2;

    public GameRound(long id, long points, String gameId, String createdAt, Player player1, Player player2) {
        this.id = id;
        this.points = points;
        this.gameId = gameId;
        this.createdAt = createdAt;
        this.player1 = player1;
        this.player2 = player2;
    }

    public long getId() {
        return id;
    }

    public long getPoints() {
        return points;
    }

    public String getGameId() {
        return gameId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameRound gameRound = (GameRound) o;
        return getId() == gameRound.getId() &&
                getPoints() == gameRound.getPoints() &&
                Objects.equals(getGameId(), gameRound.getGameId()) &&
                Objects.equals(getCreatedAt(), gameRound.getCreatedAt()) &&
                Objects.equals(getPlayer1(), gameRound.getPlayer1()) &&
                Objects.equals(getPlayer2(), gameRound.getPlayer2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getId(),
                getPoints(),
                getGameId(),
                getCreatedAt(),
                getPlayer1(),
                getPlayer2());
    }
}
