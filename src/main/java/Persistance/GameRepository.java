package Persistance;

import Model.Game;

public interface GameRepository {
    Game[] loadGames();

    void save(Game[] games, SaveBehavior behavior);

    void merge(Game[] games, MergeBehavior behavior);
}
