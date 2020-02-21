package Persistance.Json;

import Model.Game;
import Persistance.GameRepository;
import Persistance.MergeBehavior;
import Persistance.SaveBehavior;
import Utils.ArrayUtils;

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
                Game[] savedGames = loadGames(); //saved games
                Game[] sum = new Game[games.length  + savedGames.length];
                ArrayUtils.copy(games,savedGames,sum);
                save(sum);
                break;
            default:
                save(games);
                break;
        }
    }

    private void save(Game[] games) {
        JsonWriter writer = new JsonWriter(file);
        writer.write(games);
    }

    @Override
    public void merge(Game[] games, MergeBehavior behavior) {
        switch (behavior) {
            case DONT_APPEND_DUPLICATE_GAMES:
                mergeWithoutDuplicate(games);
                break;
            default:
                mergeAll(games);
        }
    }

    private void mergeWithoutDuplicate(Game[] games) {
        Game[] thisRepoGames = loadGames();
        Game[] all = new Game[thisRepoGames.length + games.length];
        Set<Game> uniqueGames = new HashSet<>();
        uniqueGames.addAll(Arrays.asList(all));

        JsonWriter writer = new JsonWriter(file);
        writer.write(uniqueGames.toArray(new Game[uniqueGames.size()]));
    }

    private void mergeAll(Game[] games) {
        Game[] savedGames = loadGames();
        Game[] all = new Game[savedGames.length + games.length];

        JsonWriter writer = new JsonWriter(file);
        writer.write(games);
    }
}
