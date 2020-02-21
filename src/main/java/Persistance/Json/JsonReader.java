package Persistance.Json;

import Model.Game;
import Model.GameRound;
import Model.Player;
import Model.PlayerAnswers;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static Persistance.Json.Keys.*;

final class JsonReader {

    private final JSONObject json;

    JsonReader(File file) {
        json = initJsonFrom(file);
    }

    private JSONObject initJsonFrom(File file) {
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            JSONParser parser = new JSONParser();
            return (JSONObject) parser.parse(reader);
        } catch (FileNotFoundException e) {
            System.err.println("File " + file + " not exist.");
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public Game[] getGames() {
        JSONArray gamesArray = (JSONArray) json.get(GAMES);
        Game[] games = new Game[gamesArray.size()];

        for (int i = 0; i < gamesArray.size(); i++) {
            JSONObject gameObj = (JSONObject) gamesArray.get(i);
            games[i] = getGameFrom(gameObj);
        }
        return games;
    }

    private Game getGameFrom(JSONObject gameObj) {
        String title = (String) gameObj.get(TITLE);
        JSONArray roundsArray = (JSONArray) gameObj.get(DATA);
        Game game = new Game(title);
        game.addAll(getRoundsFrom(roundsArray));
        return game;
    }

    private GameRound[] getRoundsFrom(JSONArray roundsArray) {
        GameRound[] rounds = new GameRound[roundsArray.size()];
        for (int i = 0; i < roundsArray.size(); i++) {
            JSONObject roundObj = (JSONObject) roundsArray.get(i);
            GameRound round = getRoundFrom(roundObj);
            rounds[i] = round;
        }
        return rounds;
    }

    private GameRound getRoundFrom(JSONObject roundObj) {
        long id = (long) roundObj.get(ID);
        String gameId = (String) roundObj.get(GAME_ID);
        String createdAt = (String) roundObj.get(CREATED_AT);
        long points = (long) roundObj.get(POINTS);

        Player player1 = getPlayer1From((JSONObject) roundObj.get(PLAYER_1));
        Player player2 = getPlayer2From((JSONObject) roundObj.get(PLAYER_2));
        return new GameRound(id, points, gameId, createdAt, player1, player2);
    }

    private Player getPlayer1From(JSONObject player1) {
        String username = (String) player1.get(USERNAME);
        long score = (long) player1.get(SCORE);
        long playerLeft = (long) player1.get(PLAYER_LEFT_1);
        PlayerAnswers answers = getAnswersFrom((JSONObject) player1.get(ANSWERS));
        return new Player(score, playerLeft, username, answers);
    }

    private Player getPlayer2From(JSONObject player2) {
        String username = (String) player2.get(USERNAME);
        long score = (long) player2.get(SCORE);
        long playerLeft = (long) player2.get(PLAYER_LEFT_2);
        PlayerAnswers answers = getAnswersFrom((JSONObject) player2.get(ANSWERS));
        return new Player(score, playerLeft, username, answers);
    }

    private PlayerAnswers getAnswersFrom(JSONObject answers) {
        long answer1 = (long) answers.get(ANSWER_1);
        long answer2 = (long) answers.get(ANSWER_2);
        long answer3 = (long) answers.get(ANSWER_3);
        long answer4 = (long) answers.get(ANSWER_4);
        long answer5 = (long) answers.get(ANSWER_5);
        return new PlayerAnswers(answer1, answer2, answer3, answer4, answer5);
    }
}
