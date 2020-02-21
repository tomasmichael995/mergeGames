package Persistance.Json;

import Model.Game;

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
}
