package Data;

import POJOs.Game;
import org.json.simple.JSONObject;

public class JsonRepository implements GameRepository {

    @Override
    public Game[] getGames() {
        return new Game[0];
    }
}
