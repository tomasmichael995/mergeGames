package Data;

import POJOs.Game;

public interface GameRepository {
    Game[] loadGames();

    void save(Game[] games);
}
