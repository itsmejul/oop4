package fische;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Aquarium {
	public Map<String, Fish> fishMap;
	
	public Aquarium() {
		fishMap = new HashMap<>();
	}
	
    public void addFish(String name, int cost, List<String> incompatibleFish) {
    	Fish fish = new Fish(name, cost, incompatibleFish);
    	fishMap.put(name, fish);
    }
    
    public List<Fish> findCompatibleFish(int budget){
    	List<Fish> fishList = new ArrayList<>(); //empty fishList
    	fishList = findCompatibleFishRecursive(budget, fishList);
    	return fishList;
    }
    
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