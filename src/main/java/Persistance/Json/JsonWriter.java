package Persistance.Json;

import Model.Game;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

final class JsonWriter {
    private final File file;

    public JsonWriter(File file) {
        this.file = file;
    }

    public void write(Game[] games) {
        try (FileWriter wr = new FileWriter(file)) {
            JSONObject root = JsonModelWrapper.wrapIntoJsonObject(games);
            wr.write(root.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
