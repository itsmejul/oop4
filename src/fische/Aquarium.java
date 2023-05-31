package fische;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
/**
 * Aquarium-Klasse instanziiert die Fische und
 * enthaelt die rekursive Logik fuer die artenreichste Fischliste
 * zu einem bestimmten Budget
 * @author Simon Hoffmann und Julian Mosig von Aehrenfeld
 *
 */
public class Aquarium {
	public Map<String, Fish> fishMap;
	/**
	 * Konstruktor
	 */
	public Aquarium() {
		fishMap = new HashMap<>();
	}
	/**
	 * Methode fuegt einen Fisch dem Sortiment hinzu
	 * @param name Name vom Fisch
	 * @param cost Kosten vom Fisch
	 * @param incompatibleFish Liste von inkompatiblen Fischen
	 */
    public void addFish(String name, int cost, List<String> incompatibleFish) {
    	Fish fish = new Fish(name, cost, incompatibleFish);
    	fishMap.put(name, fish);
    }
    /**
     * Methode ermittelt den Preis vom billigsten Fisch
     * @return Preis vom billigsten Fisch
     */
    public int cheapestFish() {
    	int min = 1000000000;
    	for(Map.Entry<String, Fish> entry : fishMap.entrySet()) {
    		Fish selectedFish = entry.getValue();
    		if(min > selectedFish.getCost()) {
    			min = selectedFish.getCost();
    		}
    	}
    	return min;
    }
    /**
     * Hilfsmethode fuer findCompatibleFishRecursive
     * @param budget Budget fuer die Fisch
     * @return Liste mit der meisten Artenvielfalt
     */
    public List<Fish> findCompatibleFish(int budget){
    	List<Fish> fishList = new ArrayList<>(); //empty fishList
    	fishList = findCompatibleFishRecursive(budget, fishList);
    	return fishList;
    }
    /**
     * Rekursive Methode zur Bestimmung von der Artenreichsten Liste fuer ein bestimmtes Budget
     * @param budget Budget fuer die Fische
     * @param fishList uebergebene Fischliste
     * @return Fischliste
     */
    private List<Fish> findCompatibleFishRecursive(int budget, List<Fish> fishList) {
    	Map<List<Fish>, Integer> diversity = new HashMap<>(); //speichert alle Möglichkeiten
    	if (budget <= cheapestFish() || fishList.size() == fishMap.size()) {
    		if(fishList.isEmpty()) {
    			System.out.println("Ihr Budget ist geringer als der billigste Fisch!");
    		}
    		return fishList;
    	}
    	for(Map.Entry<String, Fish> entry : fishMap.entrySet()) {
    		Fish selectedFish = entry.getValue();
    		if (!fishList.contains(selectedFish) && selectedFish.getCost() <= budget) {
    			boolean isCompatible = true;
    			for (Fish tempFish : fishList) {
    				if (tempFish.isIncompatible(selectedFish.getName()) || tempFish.equals(selectedFish)) {
    					isCompatible = false;
    					break;
    				}
    			}
    			
    			if(isCompatible) {
	    			int cost = budget - selectedFish.getCost();
					//System.out.println(cost);
					if (cost >= 0) {
						List<Fish> tempList = new ArrayList<>(fishList);
						tempList.add(selectedFish);
						tempList = findCompatibleFishRecursive(cost, tempList);
						diversity.put(tempList, tempList.size());	
	    			}
    			}
    		}
    	}
    	List<Fish> optimum = new ArrayList<>(fishList);
    	int maxSpecies = 0;
    	for (Map.Entry<List<Fish>,Integer> div : diversity.entrySet()) {
    		if(div.getValue() > maxSpecies) {
    			maxSpecies = div.getValue();
    			optimum = div.getKey();
    		}
    	}
    	return optimum;
    }
}