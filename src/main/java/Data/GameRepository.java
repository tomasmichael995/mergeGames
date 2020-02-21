package Data;

import Model.Game;

public interface GameRepository {
    Game[] loadGames();

    void save(Game[] games);
}
