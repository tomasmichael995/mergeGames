package Persistance.Json;

import Model.Game;
import Persistance.GameRepository;
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
                Game[] sum = new Game[games.length + savedGames.length];
                ArrayUtils.copy(games, savedGames, sum);
                save(sum);
                break;
            default:
                save(games);
        }
    }

    private void save(Game[] games) {
        JsonWriter writer = new JsonWriter(file);
        writer.write(games);
    }

    @Override
    public void merge(Game[] games) {
        Game[] savedGames = loadGames();
        Game[] sum = new Game[savedGames.length + games.length];
        ArrayUtils.copy(games, savedGames, sum);

        Set<Game> gameSet = new HashSet<>();
        gameSet.addAll(Arrays.asList(sum));

        Game[] uniqueGames = gameSet.toArray(new Game[gameSet.size()]);
        save(uniqueGames);
    }
}
