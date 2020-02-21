package Data;

import Model.Game;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;

import static Data.JsonKeys.*;

public final class JsonRepository implements GameRepository {
    private final JsonReader reader;

    public JsonRepository(String filePath) {
        File file = new File(filePath);
        reader = new JsonReader(file);
    }

    @Override
    public Game[] loadGames() {
        return reader.getGames();
    }

    @Override
    public void save(Game[] games) {

    }
}
