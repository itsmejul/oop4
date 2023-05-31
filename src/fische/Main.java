package fische;
import java.util.ArrayList;
import java.util.List;

import de.oop2023.util.UserInterface;
public class Main {
    public static void main(String[] args) throws Exception {
        //liste von den gegebenen fischen erstellen namens fishTypes
    	
    	/**
        Fish grueneMigraene = new Fish("gruene migraene", 70, new ArrayList<String>());
        Fish korallenQualle = new Fish("korallenqualle", 50, new ArrayList<String>());
        Fish schuppenschatulle = new Fish("schuppenschatulle", 30, new ArrayList<String>());
        Fish breitmaulmolch = new Fish("breitmaulmolch", 40, new ArrayList<String>());
        Fish prachtpiranha = new Fish("prachtpiranha", 40, new ArrayList<String>());
        Fish zitterling = new Fish("zitterling", 30, new ArrayList<String>());
        Fish grottenspotte = new Fish("grottenspotte", 20, new ArrayList<String>());

        grueneMigraene.addIncompatibleType("breitmaulmolch");
        grueneMigraene.addIncompatibleType("grottenspotte");
        schuppenschatulle.addIncompatibleType("breitmaulmolch");
        schuppenschatulle.addIncompatibleType("prachtpiranha");
        breitmaulmolch.addIncompatibleType("grueneMigraene");
        breitmaulmolch.addIncompatibleType("schuppenschatulle");
        prachtpiranha.addIncompatibleType("schuppenschatulle");
        prachtpiranha.addIncompatibleType("grottenspotte");
        zitterling.addIncompatibleType("grottenspotte");
        grottenspotte.addIncompatibleType("grueneMigraene");
        grottenspotte.addIncompatibleType("prachtpiranha");
        grottenspotte.addIncompatibleType("zitterling");


        List<Fish> fishTypes = new ArrayList<Fish>();
        fishTypes.add(grueneMigraene);
        fishTypes.add(grottenspotte);
        fishTypes.add(korallenQualle);
        fishTypes.add(schuppenschatulle);
        fishTypes.add(breitmaulmolch);
        fishTypes.add(prachtpiranha);
        fishTypes.add(zitterling);
        
        int budget = 170;

        //Aquarium recursion = new Aquarium(fishTypes, budget);
        //List<Fish> shopFish = recursion.compatibility(budget, fishTypes);
        List<Fish> maxFish = recursion.findMaxFishTypes(budget, 0, new ArrayList<Fish>());        
        System.out.println("-------------------------------------------------\n");
        for(Fish f : maxFish){
        //for(Fish f : shopFish){
            System.out.println(f.getName());
            
        }
        System.out.println("Maximale Anzahl an Fischen: " + recursion.findMaxFishTypes(budget, 0, new ArrayList<Fish>()).size());
    	**/
    	Aquarium aquarium = new Aquarium();
    	//Hinzufuegen von Fischen
    	aquarium.addFish("grueneMigraene", 70, new ArrayList<String>());
    	aquarium.addFish("korallenqualle", 50, new ArrayList<String>());
    	aquarium.addFish("schuppenschatulle", 30, new ArrayList<String>());
    	aquarium.addFish("breitmaulmolch", 40, new ArrayList<String>());
    	aquarium.addFish("prachtpiranha", 40, new ArrayList<String>());
    	aquarium.addFish("zitterling", 30, new ArrayList<String>());
    	aquarium.addFish("grottenspotte", 20, new ArrayList<String>());
    	
    	//Hinzufuegen Unvertraeglichkeiten
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
