package POJOs;

public class GameData {
    private int id;
    private int points;
    private String gameId;
    private String createdAt;
    private Player player1, player2;

    public int getId() {
        return id;
    }

    public int getPoints() {
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
