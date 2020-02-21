import Model.Game;
import Model.GameRound;
import Model.Player;
import Model.PlayerAnswers;
import Persistance.GameRepository;
import Persistance.Json.JsonRepository;

import java.io.IOException;
import java.util.Arrays;

public class MainClass {

    public static void main(String[] args) throws IOException {
        GameRepository one = new JsonRepository("files/one.json");
        Game[] oneGames = one.loadGames();
        one.save(oneGames, "files/oneCopy.json");
    }
}