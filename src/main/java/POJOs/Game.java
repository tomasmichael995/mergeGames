package POJOs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Game {
    private String title;
    private List<GameData> gameDatas;

    public Game(String title) {
        this.title = title;
        this.gameDatas = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public Iterator<GameData> getAllGameDatas() {
        return gameDatas.iterator();
    }

    public void add(GameData data){
        gameDatas.add(data);
    }
}
