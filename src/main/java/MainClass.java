import Model.Game;
import Persistance.GameRepository;
import Persistance.Json.JsonRepository;

import java.io.IOException;

public class MainClass {

    public static void main(String[] args) throws IOException {
        GameRepository repo = new JsonRepository("files/one.json");
        Game[] games = repo.loadGames();
        for (Game g : games) {
            System.out.println(g.getTitle());
        }
    }
}