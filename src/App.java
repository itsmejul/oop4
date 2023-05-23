import java.util.ArrayList;
import java.util.List;
public class App {
    public static void main(String[] args) throws Exception {
        //liste von den gegebenen fischen erstellen namens fishTypes
        Fish grueneMigraene = new Fish("gruene migraene", 70, new ArrayList<Fish>());
        Fish korallenQualle = new Fish("korallenqualle", 50, new ArrayList<Fish>());
        Fish schuppenschatulle = new Fish("schuppenschatulle", 30, new ArrayList<Fish>());
        Fish breitmaulmolch = new Fish("breitmaulmolch", 40, new ArrayList<Fish>());
        Fish prachtpiranha = new Fish("prachtpiranha", 40, new ArrayList<Fish>());
        Fish zitterling = new Fish("zitterling", 30, new ArrayList<Fish>());
        Fish grottenspotte = new Fish("grottenspotte", 20, new ArrayList<Fish>());

        grueneMigraene.addIncompatibleType(breitmaulmolch);
        grueneMigraene.addIncompatibleType(grottenspotte);
        schuppenschatulle.addIncompatibleType(breitmaulmolch);
        schuppenschatulle.addIncompatibleType(prachtpiranha);
        breitmaulmolch.addIncompatibleType(grueneMigraene);
        breitmaulmolch.addIncompatibleType(schuppenschatulle);
        prachtpiranha.addIncompatibleType(schuppenschatulle);
        prachtpiranha.addIncompatibleType(grottenspotte);
        zitterling.addIncompatibleType(grottenspotte);
        grottenspotte.addIncompatibleType(grueneMigraene);
        grottenspotte.addIncompatibleType(prachtpiranha);
        grottenspotte.addIncompatibleType(zitterling);


        List<Fish> fishTypes = new ArrayList<Fish>();
        fishTypes.add(grueneMigraene);
        fishTypes.add(grottenspotte);
        fishTypes.add(korallenQualle);
        fishTypes.add(schuppenschatulle);
        fishTypes.add(breitmaulmolch);
        fishTypes.add(prachtpiranha);
        fishTypes.add(zitterling);
        
        int budget = 170;

        Recursion recursion = new Recursion(fishTypes, budget);

        List<Fish> maxFish = recursion.findMaxFishTypes(budget, 0, new ArrayList<Fish>(budget));
        System.out.println("Maximale Anzahl an Fischen: " + maxFish.size());
    }
}
