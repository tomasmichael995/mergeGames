package Persistance;

import Model.Game;

public interface GameRepository {
    Game[] loadGames();

    void save(Game[] games, String filePath);

    void merge(Game[] games, MergeBehavior behavior);
}
