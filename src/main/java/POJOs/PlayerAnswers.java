package POJOs;

public class PlayerAnswers {
    private final int answer1;
    private final int answer2;
    private final int answer3;
    private final int answer4;
    private final int answer5;

    public PlayerAnswers(int answer1, int answer2, int answer3, int answer4, int answer5) {
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.answer5 = answer5;
    }

    public int getAnswer1() {
        return answer1;
    }

    public int getAnswer2() {
        return answer2;
    }

    public int getAnswer3() {
        return answer3;
    }

    public int getAnswer4() {
        return answer4;
    }

    public int getAnswer5() {
        return answer5;
    }
}
