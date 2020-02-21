package Persistance.Json;

import Model.Game;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class JsonAppender {
    private final File file;

    public JsonAppender(File file) {
        this.file = file;
    }

    public void append(Game[] games) {
        try (FileWriter wr = new FileWriter(file)) {
            JSONObject root = JsonModelWrapper.wrapIntoJsonObject(games);
            wr.append(root.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
