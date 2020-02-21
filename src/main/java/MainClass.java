import Model.Game;
import Persistance.GameRepository;
import Persistance.Json.JsonRepository;
import Persistance.MergeBehavior;
import Persistance.SaveBehavior;

import java.io.IOException;

public class MainClass {
    private static final String FILE_ONE = "files/one.json";
    private static final String FILE_TEST = "files/test.json";

    public static void main(String[] args) throws IOException {
        GameRepository oneRep = new JsonRepository(FILE_ONE);
        Game[] oneGames = oneRep.loadGames();

        GameRepository testRep = new JsonRepository(FILE_TEST);
        testRep.save(oneGames, SaveBehavior.APPEND);
    }
}