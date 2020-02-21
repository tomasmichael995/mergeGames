package Data;

import POJOs.Game;
import POJOs.GameData;
import POJOs.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static Data.JsonConstants.*;

public class JsonRepository implements GameRepository {
    private File file;

    public JsonRepository(String filePath) {
        file = new File(filePath);
    }

    @Override
    public Game[] getGames() {
        JSONObject json = getTopJsonObj();
        JSONArray gameObjs = (JSONArray) json.get(GAMES_KEY);
        Game[] games = new Game[gameObjs.size()];

        for (int i = 0; i < gameObjs.size(); i++) {
            JSONObject gameObj = (JSONObject) gameObjs.get(i);
            String title = (String) gameObj.get(TITLE_KEY);
            Game game = new Game(title);
            games[i] = game;

            JSONArray gameDatas = (JSONArray) gameObj.get(DATA_KEY);
            for (int j = 0; j < gameDatas.size(); j++) {
                JSONObject dataObj = (JSONObject) gameDatas.get(j);
                GameData data = JsonToPojos.GameDataFrom(dataObj);
                game.add(data);
            }
        }
        return games;
    }

    private JSONObject getTopJsonObj() {
        try {
            FileReader reader = new FileReader(file);
            JSONParser parser = new JSONParser();
            return (JSONObject) parser.parse(reader);
        } catch (FileNotFoundException e) {
            System.err.println("File "+file+ " not exists");
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
