package Persistance.Json;

import Model.Game;
import Persistance.GameRepository;
import Persistance.MergeBehavior;
import Persistance.SaveBehavior;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class JsonRepository implements GameRepository {
    private final File file;

    public JsonRepository(String filePath) {
        file = new File(filePath);
    }

    @Override
    public Game[] loadGames() {
        return new JsonReader(file).getGames();
    }

    @Override
    public void save(Game[] games, SaveBehavior behavior) {
        switch (behavior) {
            case APPEND:
                // TODO: write implementation
                break;
            default:
                JsonWriter writer = new JsonWriter(file);
                writer.write(games);
                break;
        }
    }

    @Override
    public void merge(Game[] games, MergeBehavior behavior) {
        switch (behavior) {
            case DONT_APPEND_DUPLICATE_GAMES:
                mergeWithoutDuplicate(games, file);
                break;
            default:
                mergeAll(games, file);
        }
    }

    private void mergeAll(Game[] games, File file) {
        Game[] thisRepoGames = loadGames();
        Game[] all = new Game[thisRepoGames.length + games.length];

        JsonWriter writer = new JsonWriter(file);
        writer.write(games);
    }

    private void mergeWithoutDuplicate(Game[] games, File file) {
        Game[] thisRepoGames = loadGames();
        Game[] all = new Game[thisRepoGames.length + games.length];
        Set<Game> uniqueGames = new HashSet<>();
        uniqueGames.addAll(Arrays.asList(all));

        JsonWriter writer = new JsonWriter(file);
        writer.write(uniqueGames.toArray(new Game[uniqueGames.size()]));
    }
}
