import java.io.File;
import java.util.Map;
import java.util.TreeMap;

public class MainClass {

    public static void main(String[] args) {

        JReader jReaderOne = new JReader(new File("files/one.json"));
        JReader jReaderTwo = new JReader(new File("files/two.json"));
        JReader jReaderThree = new JReader(new File("files/three.json"));
        JReader jReaderResults = new JReader(new File("files/results.json"));

        // Parse files and get their contents in 3 separate hashmaps
        Map<Long, String> map1 = jReaderOne.getDatesAndGameIDs();
        Map<Long, String> map2 = jReaderTwo.getDatesAndGameIDs();
        Map<Long, String> map3 = jReaderThree.getDatesAndGameIDs();

        // Parse results file and get results in 2 separate hashmaps, which have been added in any arraylist
        Map<Long, String> mapResultsOneAndTwo = jReaderResults.getAllResults().get(0);
        Map<Long, String> mapResultsOneAndThree = jReaderResults.getAllResults().get(1);

        // Implementation of mergeGames method
        Map<Long, String> finalMap1 = mergeGames(map1, map2);
        Map<Long, String> finalMap2 = mergeGames(map1, map3);

        // Final comparison
        if (compareResults(finalMap1,mapResultsOneAndTwo))
            System.out.println("Files one.json and two.json have been merged successfully!");
        if (compareResults(finalMap2,mapResultsOneAndThree))
            System.out.println("Files one.json and three.json have been merged successfully!");

    }

    // Inserts 2 given maps into a TreeMap for correct sorting by keys (game ids)
    static Map<Long,String> mergeGames(Map<Long, String> firstMap, Map<Long, String> secondMap) {

        Map<Long, String> finalMap = new TreeMap<>();
        finalMap.putAll(firstMap);
        finalMap.putAll(secondMap);
//        finalMap.forEach((gameID, date) -> System.out.println("Game_ID=" + gameID + " / " + "Date=" + date));

        return finalMap;
    }

    // Comparison between 2 given maps
    static boolean compareResults(Map<Long, String> firstMap, Map<Long, String> secondMap) {

        if (firstMap.equals(secondMap))
            return true;
        return false;
    }
}