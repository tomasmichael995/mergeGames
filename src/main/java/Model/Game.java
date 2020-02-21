package Model;

import java.util.*;

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

    public GameRound[] getRounds() {
        return rounds.toArray(new GameRound[rounds.size()]);
    }

    public void add(GameRound round) {
        rounds.add(round);
    }

    public void addAll(GameRound[] rounds) {
        List<GameRound> list = Arrays.asList(rounds);
        this.rounds.addAll(list);
    }
}
