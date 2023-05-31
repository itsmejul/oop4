package fische;
import java.util.ArrayList;
import java.util.List;
import de.oop2023.util.UserInterface;
/**
 * Main-Klasse instanziiert ein Aquarium mit dem Sortiment an Fischen,
 * fragt mittels des UserInterfaces das Budget vom Benutzer ab
 * und ruft dann die Methoden zur Bestimmung der artenreichsten Fischliste auf.
 * @author Simon Hoffmann und Julian Mosig von Aehrenfeld
 * @version 69.69
 */
public class Main {
	/**
	 * Mainmethode
	 * @param args
	 * @throws Exception
	 */
    public static void main(String[] args) throws Exception {
    	Aquarium aquarium = new Aquarium();
    	aquarium.addFish("grueneMigraene", 70, new ArrayList<String>());
    	aquarium.addFish("korallenqualle", 50, new ArrayList<String>());
    	aquarium.addFish("schuppenschatulle", 30, new ArrayList<String>());
    	aquarium.addFish("breitmaulmolch", 40, new ArrayList<String>());
    	aquarium.addFish("prachtpiranha", 40, new ArrayList<String>());
    	aquarium.addFish("zitterling", 30, new ArrayList<String>());
    	aquarium.addFish("grottenspotte", 20, new ArrayList<String>());
    	
    	aquarium.fishMap.get("grueneMigraene").addIncompatibleType("breitmaulmolch");
    	aquarium.fishMap.get("grueneMigraene").addIncompatibleType("grottenspotte");
    	aquarium.fishMap.get("schuppenschatulle").addIncompatibleType("breitmaulmolch");
    	aquarium.fishMap.get("schuppenschatulle").addIncompatibleType("prachtpiranha");
    	aquarium.fishMap.get("breitmaulmolch").addIncompatibleType("grueneMigraene");
    	aquarium.fishMap.get("breitmaulmolch").addIncompatibleType("schuppenschatulle");
    	aquarium.fishMap.get("prachtpiranha").addIncompatibleType("schuppenschatulle");
    	aquarium.fishMap.get("prachtpiranha").addIncompatibleType("grottenspotte");
    	aquarium.fishMap.get("zitterling").addIncompatibleType("grottenspotte");
    	aquarium.fishMap.get("grottenspotte").addIncompatibleType("grueneMigraene");
    	aquarium.fishMap.get("grottenspotte").addIncompatibleType("prachtpiranha");
    	aquarium.fishMap.get("grottenspotte").addIncompatibleType("zitterling");
    	
    	int budget = UserInterface.in.requestInt("Geben Sie das Budget ein: ", 0);
    	List<Fish> selectedFish = aquarium.findCompatibleFish(budget);
    	
    	System.out.println("Ausgewählte Fische für das Aquarium (Budget: " + budget + "):");
    	for (Fish fish : selectedFish) {
    		int fishCost = fish.getCost();
    		System.out.println(fish.getName() + " : " + fishCost);
    	}
    }
}
