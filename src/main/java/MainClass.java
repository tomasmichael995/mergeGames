import Model.Game;
import Persistance.GameRepository;
import Persistance.Json.JsonRepository;

import java.io.IOException;

public class MainClass {

    public static void main(String[] args) throws IOException {
        GameRepository one = new JsonRepository("files/one.json");
        Game[] oneGames = one.loadGames();
        one.save(oneGames, "files/oneCopy.json");
    }
}