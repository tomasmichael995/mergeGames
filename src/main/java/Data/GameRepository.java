package Data;

import POJOs.Game;

public interface GameRepository<T> {
    Game[] getGamesFrom(T provider);
}
