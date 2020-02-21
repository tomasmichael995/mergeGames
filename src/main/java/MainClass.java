import Data.GameRepository;
import Data.JsonRepository;
import Model.Game;

import java.io.IOException;

public class MainClass {

    public static void main(String[] args) throws IOException {
        GameRepository repo = new JsonRepository("files/one.json");
        Game[] games = repo.loadGames();
        for (Game g: games) {
            System.out.println(g.getTitle());
        }
    }
}