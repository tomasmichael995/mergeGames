package Data;

import POJOs.Game;

import java.io.File;

public class JsonRepository implements GameRepository {
    private File file;

    public JsonRepository(String filePath) {
        file = new File(filePath);
    }

    @Override
    public Game[] getGames() {
        return new Game[0];
    }
}
