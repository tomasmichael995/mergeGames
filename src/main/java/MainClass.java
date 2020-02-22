import Persistance.GameRepository;
import Json.JsonRepository;
import Persistance.SaveBehavior;

import java.io.IOException;

public class MainClass {
    
    public static void main(String[] args) throws IOException {
        GameRepository firstRep = new JsonRepository("files/one.json");
        GameRepository secondRep = new JsonRepository("files/two.json");
        GameRepository thirdRep = new JsonRepository("files/three.json");
        GameRepository resultRep = new JsonRepository("files/result.json");
        
        resultRep.save(firstRep.loadGames(), SaveBehavior.WRITE);
        resultRep.merge(secondRep.loadGames());
        resultRep.merge(thirdRep.loadGames());

        System.out.println("Operation finished, check " + "files/result.json file.");
    }
}