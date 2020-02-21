package Model;

public final class PlayerAnswers {
    private final long answer1;
    private final long answer2;
    private final long answer3;
    private final long answer4;
    private final long answer5;

    public PlayerAnswers(long answer1, long answer2, long answer3, long answer4, long answer5) {
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.answer5 = answer5;
    }

    public long getAnswer1() {
        return answer1;
    }

    public long getAnswer2() {
        return answer2;
    }

    public long getAnswer3() {
        return answer3;
    }

    public long getAnswer4() {
        return answer4;
    }

    public long getAnswer5() {
        return answer5;
    }
}
