package JSON;

import org.json.simple.JSONObject;

public interface JsonReader {
    JSONObject readJsonFrom(String file);
}
