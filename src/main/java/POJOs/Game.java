package POJOs;

public class Game {
    private String title;
    private GameData[] games;

    public Game(String title, GameData[] games) {
        this.title = title;
        this.games = games;
    }

    public String getTitle() {
        return title;
    }

    public GameData[] getGames() {
        return games;
    }
}
