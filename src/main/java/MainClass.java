import Data.GameRepository;
import Data.JsonRepository;
import POJOs.Game;
import org.json.simple.JSONArray;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class MainClass {

    public static void main(String[] args) throws IOException {
        GameRepository repo = new JsonRepository("files/one.json");
        Game[] games = repo.getGames();
        for (Game g: games) {
            System.out.println(g.getTitle());
        }
    }
}