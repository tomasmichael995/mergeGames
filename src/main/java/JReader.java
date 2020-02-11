import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JReader {

    private File file;

    public JReader(File file) {
        this.file = file;
    }

    // Method to parse a given JSON file and return its content
    public JSONObject parseFile() {

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = null;


        try (FileReader fileReader = new FileReader(file)) {

            jsonObject = (JSONObject) jsonParser.parse(fileReader);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return jsonObject;
    }

    // Parses JSON content and add game ids and dates into a hashmap
    // Game ids are considered unique so they are added as keys for deduplication
    public Map<Long, String> getDatesAndGameIDs() {

        Map<Long, String> data = new HashMap<Long, String>();

        JSONObject jsonContent = parseFile();
        JSONArray gamesArray = (JSONArray) jsonContent.get("games");

        for (int i = 0; i < gamesArray.size(); i++) {

            JSONObject gameObject = (JSONObject) gamesArray.get(i);
            String date = (String) gameObject.get("title");

            JSONArray dataArray = (JSONArray) gameObject.get("data");

            for (int j = 0; j < dataArray.size(); j++) {

                JSONObject dataObject = (JSONObject) dataArray.get(j);
                Long id = (Long) dataObject.get("id");
                data.put(id, date);
            }
        }
        return data;
    }

    // Parses results file, add data in 2 separate hashmaps (depending on main object's name-value)
    // At last, these maps are added into an arraylist
    public List<Map<Long,String>> getAllResults() {

        Map<Long, String> resultsOneAndTwo = new HashMap<Long, String>();
        Map<Long, String> resultsOneAndThree = new HashMap<Long, String>();
        List<Map<Long,String>> mapsList = new ArrayList<Map<Long,String>>();

        JSONObject jsonContent = parseFile();

        JSONObject oneAndTwoComparisonResults = (JSONObject) jsonContent.get("mergeOne&Two");
        JSONArray gamesArray = (JSONArray) oneAndTwoComparisonResults.get("games");

        for (int i = 0; i < gamesArray.size(); i++) {

            JSONObject gameObject = (JSONObject) gamesArray.get(i);
            String date = (String) gameObject.get("title");

            JSONArray dataArray = (JSONArray) gameObject.get("data");

            for (int j = 0; j < dataArray.size(); j++) {

                JSONObject dataObject = (JSONObject) dataArray.get(j);
                Long id = (Long) dataObject.get("id");
                resultsOneAndTwo.put(id, date);
            }
        }

        JSONObject comparisonResultsOneAndThree = (JSONObject) jsonContent.get("mergeOne&Three");
        JSONArray gamesArray2 = (JSONArray) comparisonResultsOneAndThree.get("games");

        for (int i = 0; i < gamesArray2.size(); i++) {

            JSONObject gameObject = (JSONObject) gamesArray2.get(i);
            String date = (String) gameObject.get("title");

            JSONArray dataArray = (JSONArray) gameObject.get("data");

            for (int j = 0; j < dataArray.size(); j++) {

                JSONObject dataObject = (JSONObject) dataArray.get(j);
                Long id = (Long) dataObject.get("id");
                resultsOneAndThree.put(id, date);
            }
        }

        mapsList.add(resultsOneAndTwo);
        mapsList.add(resultsOneAndThree);

        return mapsList;
    }
}