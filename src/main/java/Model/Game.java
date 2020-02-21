package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class Game implements Comparable<Game> {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(getTitle(), game.getTitle()) &&
                Arrays.equals(getRounds(), game.getRounds());
    }

    @Override
    public int hashCode() {
        int titleHash = Objects.hash(getTitle()) + 7;
        int roundsHash = Arrays.hashCode(getRounds()) + 31;
        return titleHash * roundsHash;
    }

    @Override
    public int compareTo(Game o) {
        if (hashCode() < o.hashCode()) {
            return -1;
        } else if (hashCode() > o.hashCode()) {
            return 1;
        }
        return 0;
    }
}
