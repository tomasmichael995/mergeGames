import org.json.simple.JSONArray;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

public class MainClass {

    public static void main(String[] args) {

        JReader jReaderOne = new JReader(new File("files/one.json"));
        JReader jReaderTwo = new JReader(new File("files/two.json"));
        JReader jReaderThree = new JReader(new File("files/three.json"));
        JReader jReaderResults = new JReader(new File("files/results.json"));

        // Parse json files and get their contents in 3 separate hashmaps
        Map<String, JSONArray> map1 = jReaderOne.getDataFromArrayOfGames();
        Map<String, JSONArray> map2 = jReaderTwo.getDataFromArrayOfGames();
        Map<String, JSONArray> map3 = jReaderThree.getDataFromArrayOfGames();

        // Parse results json file and get results for confirmation
        Map<String, JSONArray> mapResultsOneAndTwo = jReaderResults.getResultsForConfirmation("mergeOne&Two");
        Map<String, JSONArray> mapResultsOneAndThree = jReaderResults.getResultsForConfirmation("mergeOne&Three");

        Map<String, JSONArray> finalMap1 = mergeGames(map1, map2);
        Map<String, JSONArray> finalMap2 = mergeGames(map1, map3);

        // Comparison for confirmation
        if (compareResults(finalMap1, mapResultsOneAndTwo))
            System.out.println("Files one.json and two.json have been merged successfully!");
        if (compareResults(finalMap2, mapResultsOneAndThree))
            System.out.println("Files one.json and three.json have been merged successfully!");
    }

    // Implementation of the requested mergeGames method
    // Inserts 2 given maps into a TreeMap for deduplication of values and sorting by keys (dates)
    static Map<String, JSONArray> mergeGames(Map<String, JSONArray> firstMap, Map<String, JSONArray> secondMap) {

        Map<String, JSONArray> finalMap = new TreeMap<>();
        finalMap.putAll(firstMap);
        finalMap.putAll(secondMap);
        return finalMap;
    }

    // Comparison between 2 given maps
    static boolean compareResults(Map<String, JSONArray> firstMap, Map<String, JSONArray> secondMap) {
        return firstMap.equals(secondMap);
    }
}