import Model.Game;
import Persistance.GameRepository;
import Persistance.Json.JsonRepository;
import Persistance.MergeBehavior;

import java.io.IOException;

public class MainClass {
    private static final String FILE_ONE = "files/one.json";
    private static final String FILE_ONE_COPY = "files/oneCopy.json";

    public static void main(String[] args) throws IOException {
        GameRepository rep1 = new JsonRepository(FILE_ONE);
        Game[] games1 = rep1.loadGames();
        rep1.save(games1, FILE_ONE_COPY);

        GameRepository rep2 = new JsonRepository(FILE_ONE_COPY);
        Game[] games2 = rep2.loadGames();

        rep2.merge(games1, FILE_ONE_COPY, MergeBehavior.APPEND_ALL_GAMES);

        System.out.println("Finished.");
    }
}