import Model.Game;
import Persistance.GameRepository;
import Persistance.Json.JsonRepository;

import java.io.IOException;
import java.util.Arrays;

public class MainClass {
    private static final String FILE_ONE = "files/one.json";
    private static final String FILE_TWO = "files/two.json";
    private static final String FILE_THREE = "files/three.json";
    private static final String FILE_TEST = "files/test.json";

    public static void main(String[] args) throws IOException {
        GameRepository oneRep = new JsonRepository(FILE_ONE);
        Game[] oneGames = oneRep.loadGames();

        GameRepository testRep = new JsonRepository(FILE_TEST);
        testRep.merge(oneGames);
        Game[] testGames = testRep.loadGames();

        // Sort first because Arrays.equals() is considering also elements position
        // to calculate equality
        Arrays.sort(oneGames);
        Arrays.sort(testGames);
        boolean identical = Arrays.equals(oneGames, testGames);

        // Works if true!
        System.out.println("Are the games identical? " + identical);
    }
}