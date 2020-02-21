package Persistance.Json;

import Model.Game;
import Model.PlayerAnswers;
import org.json.simple.JSONObject;

import java.io.File;

final class JsonWriter {
    private final File file;

    public JsonWriter(File file) {
        this.file = file;
    }

    public void write(Game[] games) {
        for (Game g : games) {
            write(g);
        }
    }

    private void write(Game g) {

    }

    private JSONObject wrapIntoJsonObject(PlayerAnswers pA) {
        JSONObject answersObj = new JSONObject();
        long[] all = pA.getAll();

        for (int i = 0; i < all.length; i++) {
            String prefix = Keys.getAnswerPrefix();
            String suffix = "" + (i + 1);
            String key = prefix + suffix;
            long value = all[i];
            answersObj.put(key, value);
        }

        return answersObj;
    }
}
