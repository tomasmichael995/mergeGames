package JSON;

import POJOs.Game;
import org.json.simple.JSONObject;

public interface JsonParser {
    Game ParseGameFrom(JSONObject gameJson);
}
