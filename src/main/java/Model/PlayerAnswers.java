package Model;

import java.util.Arrays;

public final class PlayerAnswers {
    private static final int SIZE = 5;

    private final long[] answers;

    public PlayerAnswers(long answer1, long answer2, long answer3, long answer4, long answer5) {
        answers = new long[SIZE];
        answers[0] = answer1;
        answers[1] = answer2;
        answers[2] = answer3;
        answers[3] = answer4;
        answers[4] = answer5;
    }

    public long[] getAll() {
        return answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerAnswers that = (PlayerAnswers) o;
        return Arrays.equals(answers, that.answers);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(answers);
    }
}
