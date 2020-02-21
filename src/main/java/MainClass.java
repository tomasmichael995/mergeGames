import Model.Game;
import Persistance.GameRepository;
import Persistance.Json.JsonRepository;

import java.io.IOException;

public class MainClass {

    public static void main(String[] args) throws IOException {
        GameRepository repo = new JsonRepository("files/one.json");
        Game[] games = repo.loadGames();
        repo.save(games,"files/oneCopy.json");
        System.out.println("Finished.");
    }
}