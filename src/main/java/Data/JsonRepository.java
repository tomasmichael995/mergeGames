package Data;

import Model.Game;

import java.io.File;

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
    public void save(Game[] games, String filePath) {
        File file = new File(filePath);
        JsonWriter writer = new JsonWriter(file);
        writer.write(games);
    }
}
