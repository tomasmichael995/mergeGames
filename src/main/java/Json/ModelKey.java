package Json;

final class ModelKey {
    public static final String GAMES = "games";
    public static final String TITLE = "title";
    public static final String DATA = "data";
    public static final String ID = "id";
    public static final String USERNAME = "username";
    public static final String SCORE = "score";
    public static final String PLAYER_LEFT_1 = "playerLeft1";
    public static final String PLAYER_LEFT_2 = "playerLeft2";
    public static final String ANSWERS = "answers";
    public static final String POINTS = "points";
    public static final String PLAYER_1 = "player1";
    public static final String PLAYER_2 = "player2";
    public static final String GAME_ID = "gameId";
    public static final String CREATED_AT = "createdAt";
    public static final String ANSWER_1 = "answer1";
    public static final String ANSWER_2 = "answer2";
    public static final String ANSWER_3 = "answer3";
    public static final String ANSWER_4 = "answer4";
    public static final String ANSWER_5 = "answer5";

    public static String getAnswerPrefix() {
        return "answer";
    }

    private ModelKey() {
    }
}
