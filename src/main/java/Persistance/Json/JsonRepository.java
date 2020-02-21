package Persistance.Json;

import Model.Game;
import Persistance.GameRepository;
import Persistance.MergeBehavior;

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

    @Override
    public void merge(Game[] games, String filePath, MergeBehavior behavior) {
        switch (behavior){
            case DONT_APPEND_DUPLICATE_GAMES:
                mergeNoDuplicate(games);
                break;
            default:
                mergeAll(games);
        }
    }

    private void mergeAll(Game[] games) {

    }

    private void mergeNoDuplicate(Game[] games) {
    }
}
