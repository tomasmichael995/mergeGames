package Data;

import POJOs.GameData;
import POJOs.Player;
import POJOs.PlayerAnswers;
import org.json.simple.JSONObject;

import static Data.JsonConstants.*;
import static Data.JsonConstants.ANSWER_5_KEY;

public class JsonToPojos {

    private JsonToPojos(){}

    public static GameData GameDataFrom(JSONObject data){
        long id = (long) data.get(ID_KEY);
        String gameId = (String) data.get(GAME_ID_KEY);
        String createdAt = (String) data.get(CREATED_AT_KEY);
        long points = (long) data.get(POINTS_KEY);

        Player player1 = JsonToPojos.Player1From((JSONObject) data.get(PLAYER_1_KEY));
        Player player2 = JsonToPojos.Player2From((JSONObject) data.get(PLAYER_2_KEY));
        return new GameData(id,points,gameId,createdAt,player1,player2);
    }

    private static Player Player1From(JSONObject player1) {
        String username = (String) player1.get(USERNAME_KEY);
        long score = (long) player1.get(SCORE_KEY);
        long playerLeft = (long) player1.get(PLAYER_LEFT_1_KEY);
        PlayerAnswers answers = PlayerAnswersFrom((JSONObject) player1.get(ANSWERS_KEY));
        return new Player(score,playerLeft,username,answers);
    }

    private static Player Player2From(JSONObject player2) {
        String username = (String) player2.get(USERNAME_KEY);
        long score = (long) player2.get(SCORE_KEY);
        long playerLeft = (long) player2.get(PLAYER_LEFT_2_KEY);
        PlayerAnswers answers = PlayerAnswersFrom((JSONObject) player2.get(ANSWERS_KEY));
        return new Player(score,playerLeft,username,answers);
    }

    private static PlayerAnswers PlayerAnswersFrom(JSONObject answers){
        long answer1 = (long) answers.get(ANSWER_1_KEY);
        long answer2 = (long) answers.get(ANSWER_2_KEY);
        long answer3 = (long) answers.get(ANSWER_3_KEY);
        long answer4 = (long) answers.get(ANSWER_4_KEY);
        long answer5 = (long) answers.get(ANSWER_5_KEY);
        return new PlayerAnswers(answer1,answer2,answer3,answer4,answer5);
    }
}
