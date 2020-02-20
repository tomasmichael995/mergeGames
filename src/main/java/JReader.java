import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.*;

public class JReader {

    private File file;

    public JReader(File file) {
        this.file = file;
    }

    // Method to parse a given JSON file and return its content
    private JSONObject parseFile() {

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = null;

        try (FileReader fileReader = new FileReader(file)) {

            jsonObject = (JSONObject) jsonParser.parse(fileReader);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return jsonObject;
    }

    private JSONArray getArrayOfGames(JSONObject jsonObject) {
        return (JSONArray) jsonObject.get("games");
    }

    public Map<String, JSONArray> getDataFromArrayOfGames() {

        JSONObject jsonObject = this.parseFile();
        JSONArray gamesArray = this.getArrayOfGames(jsonObject);
        Map<String, JSONArray> dataMap = new HashMap<>();
        this.putDatesAndDataFromJsonArrayIntoMap(gamesArray,dataMap);

        return dataMap;
    }

    // This method is used for test purposes
    public Map<String, JSONArray> getResultsForConfirmation(String mergeString) {

        JSONObject jsonContent = parseFile();
        JSONObject oneAndTwoComparisonResults = (JSONObject) jsonContent.get(mergeString);
        JSONArray gamesArray = (JSONArray) this.getArrayOfGames(oneAndTwoComparisonResults);

        Map<String, JSONArray> resultsMap = new HashMap<String, JSONArray>();
        this.putDatesAndDataFromJsonArrayIntoMap(gamesArray,resultsMap);

        return resultsMap;
    }

    private void putDatesAndDataFromJsonArrayIntoMap(JSONArray arr, Map<String, JSONArray> map) {
        for (Object game : arr) {
            JSONObject gameObject = (JSONObject) game;
            String date = (String) gameObject.get("title");
            JSONArray dataArray = (JSONArray) gameObject.get("data");
            map.put(date, dataArray);
        }
    }
}