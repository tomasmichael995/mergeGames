package Json;

import Model.Game;
import Model.GameRound;
import Model.Player;
import Model.PlayerAnswers;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

final class JsonModelWrapper {
    private JsonModelWrapper() {
    }

    public static JSONObject wrapIntoJsonObject(Game[] games) {
        JSONObject obj = new JSONObject();
        obj.put(ModelKey.GAMES, wrapIntoJsonArray(games));
        return obj;
    }

    private static JSONArray wrapIntoJsonArray(Game[] games) {
        JSONArray array = new JSONArray();
        for (Game g : games) {
            JSONObject gameObj = wrapIntoJsonObject(g);
            array.add(gameObj);
        }
        return array;
    }

    private static JSONObject wrapIntoJsonObject(Game game) {
        JSONObject gameObj = new JSONObject();
        gameObj.put(ModelKey.TITLE, game.getTitle());
        JSONArray roundsArray = wrapIntoJsonArray(game.getRounds());
        gameObj.put(ModelKey.DATA, roundsArray);
        return gameObj;
    }

    private static JSONArray wrapIntoJsonArray(GameRound[] rounds) {
        JSONArray array = new JSONArray();
        for (GameRound r : rounds) {
            array.add(wrapIntoJsonObject(r));
        }
        return array;
    }

    private static JSONObject wrapIntoJsonObject(GameRound round) {
        JSONObject obj = new JSONObject();

        obj.put(ModelKey.ID, round.getId());
        obj.put(ModelKey.GAME_ID, round.getGameId());
        obj.put(ModelKey.CREATED_AT, round.getCreatedAt());
        obj.put(ModelKey.POINTS, round.getPoints());
        obj.put(ModelKey.PLAYER_1, wrapIntoJsonObject(round.getPlayer1(), true));
        obj.put(ModelKey.PLAYER_2, wrapIntoJsonObject(round.getPlayer2(), false));

        return obj;
    }

    /**
     * Wraps player into a JsonObject.
     * The user must be cautious when setting the flag
     * because that will determine a different json key for the same value
     * (playerLeft1/playerLeft2).
     *
     * @param player
     * @param isPlayer1
     * @return
     */
    private static JSONObject wrapIntoJsonObject(Player player, boolean isPlayer1) {
        JSONObject obj = new JSONObject();

        obj.put(ModelKey.USERNAME, player.getUserName());
        obj.put(ModelKey.SCORE, player.getScore());
        JSONObject answers = wrapIntoJsonObject(player.getAnswers());
        obj.put(ModelKey.ANSWERS, answers);

        // TODO: design flaw, fix
        if (isPlayer1) {
            obj.put(ModelKey.PLAYER_LEFT_1, player.getPlayerLeft());
        } else {
            obj.put(ModelKey.PLAYER_LEFT_2, player.getPlayerLeft());
        }

        return obj;
    }

    private static JSONObject wrapIntoJsonObject(PlayerAnswers pA) {
        JSONObject answersObj = new JSONObject();
        long[] all = pA.getAll();

        for (int i = 0; i < all.length; i++) {
            String prefix = ModelKey.getAnswerPrefix();
            String key = prefix + (i + 1);
            long value = all[i];
            answersObj.put(key, value);
        }

        return answersObj;
    }
}
