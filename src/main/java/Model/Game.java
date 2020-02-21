package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class Game {
    private final String title;
    private final List<GameRound> rounds;

    public Game(String title) {
        this.title = title;
        this.rounds = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public Iterator<GameRound> getRounds() {
        return rounds.iterator();
    }

    public void add(GameRound round){
        rounds.add(round);
    }

    public void addAll(GameRound[] rounds) {
        List<GameRound> list = Arrays.asList(rounds);
        this.rounds.addAll(list);
    }
}
