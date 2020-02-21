package POJOs;

public class GameData {
    private long id;
    private long points;
    private String gameId;
    private String createdAt;
    private Player player1, player2;

    public GameData(long id, long points, String gameId, String createdAt, Player player1, Player player2) {
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
}
