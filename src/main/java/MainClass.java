import Model.Game;
import Persistance.GameRepository;
import Persistance.Json.JsonRepository;
import Persistance.SaveBehavior;
import Utils.ArrayUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MainClass {
    private static final GameRepository firstRep = new JsonRepository("files/one.json");
    private static final GameRepository secondRep = new JsonRepository("files/two.json");
    private static final GameRepository thirdRep = new JsonRepository("files/three.json");
    private static final GameRepository resultRep = new JsonRepository("files/result.json");

    public static void main(String[] args) throws IOException {
        resultRep.save(firstRep.loadGames(), SaveBehavior.WRITE);
        resultRep.merge(secondRep.loadGames());
        resultRep.merge(thirdRep.loadGames());
        System.out.println("Operation finished, check " + "files/result.json file.");
    }
}