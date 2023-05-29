package fische;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Aquarium {
	public Map<String, Fish> fishMap;
    //private List<Fish> fishTypes;
    //private int budget;

	public Aquarium() {
		fishMap = new HashMap<>();
	}
    /**public Aquarium(List<Fish> fishTypes, int budget){
        this.fishTypes = fishTypes;
        this.budget = budget;
    }**/
    
    public void addFish(String name, int cost, List<String> incompatibleFish) {
    	Fish fish = new Fish(name, cost, incompatibleFish);
    	fishMap.put(name, fish);
    }
    
    public List<String> findCompatibleFish(int budget){
    	List<String> selectedFish = new ArrayList<>();
    	findCompatibleFishRecursive(budget, selectedFish);
    	return selectedFish;
    }
    
    private void findCompatibleFishRecursive(int budget, List<String> selectedFish) {
    	if (budget <= 0 || selectedFish.size() == fishMap.size()) {
    		return;
    	}
    	int maxFishPrice = 0;
    	String  maxFishName = "";
    	
    	for(Map.Entry<String, Fish> entry : fishMap.entrySet()) {
    		String fishName = entry.getKey();
    		Fish fish = entry.getValue();
    		
    		if (!selectedFish.contains(fishName) && fish.getCost() <= budget && fish.getCost() > maxFishPrice) {
    			boolean isCompatible = true;
    			for (String selectedFishName : selectedFish) {
    				Fish selectedFishObj = fishMap.get(selectedFishName);
    				if (selectedFishObj.isIncompatible(fishName)) {
    					isCompatible = false;
    					break;
    				}
    			}
    			if (isCompatible) {
    				maxFishPrice = fish.getCost();
    				maxFishName = fishName;
    			}
    		}
    	}
    	if (!maxFishName.isEmpty()) {
    		selectedFish.add(maxFishName);
    		findCompatibleFishRecursive(budget - maxFishPrice, selectedFish);
    	}
    }
    /**public List<Fish> compatibility(int budget, List<Fish> selectedFishTypes){
    	List<Fish> fishList = new ArrayList<>();
    	List<Fish> tempList = new ArrayList<>();
    	
    	int index = 0;
    	for(Fish fish : selectedFishTypes) {
    		if(fish.getCost() <= budget) {
    			tempList = selectedFishTypes;
    			tempList.remove(index);
    			tempList = compatibility(budget-fish.getCost(),tempList);
    			if(tempList.size() > fishList.size()) {
    				fishList = tempList;
    			}
    		}
    		index++;
    	}
    	return fishList;
    }
    **/ 
	/**
    public List<Fish> findMaxFishTypes(int budget, int index, List<Fish> selectedFishTypes){
        printList(selectedFishTypes);
        System.out.println(budget + "-----" + index + "\n");
        
        if(budget < 0 || index >= fishTypes.size()){
            
            return new ArrayList<Fish>();
        }
        Fish currentFish = fishTypes.get(index);
        List<Fish> maxFishTypes;

        List<Fish> newFishTypes = new ArrayList<>(selectedFishTypes);


        if(newFishTypes.contains(currentFish)){
            return new ArrayList<Fish>(findMaxFishTypes(budget, index + 1, newFishTypes));
        }

        //aktueller Fisch ist zu teuer fuer Restbudget, also wird der naechste Fisch ausprobiert
        if(currentFish.getCost() > budget){
            maxFishTypes = new ArrayList<Fish>(findMaxFishTypes(budget, index + 1, newFishTypes));
        } 
        //aktueller Fisch passt ins Restbudget
        else {
            //schauen, ob aktueller Fisch mit bisherigen Fischen kompatibel ist
            boolean isCompatible = true;
            for(Fish incompatibleFish : currentFish.getIncompatibleTypes()){
                if(newFishTypes.contains(incompatibleFish)){
                    isCompatible = false;
                } 
            }
            //aktueller Fisch ist nicht kompatibel, betrachte naechsten moeglichen Fisch
            if(!isCompatible){
                maxFishTypes = new ArrayList<Fish>(findMaxFishTypes(budget, index + 1, newFishTypes));
            } 
            //aktueller Fisch ist kompatibel und passt ins Budget
            else{
                
                List<Fish> maxFishTypesWithoutCurrentFish;
                maxFishTypesWithoutCurrentFish = new ArrayList<Fish>(findMaxFishTypes(budget, index + 1, newFishTypes));
                
                List<Fish> newNewFishTypes = new ArrayList<Fish>(selectedFishTypes);
                newNewFishTypes.add(currentFish);
                List<Fish> maxFishTypesWithCurrentFish;
                
                maxFishTypesWithCurrentFish = new ArrayList<Fish>(findMaxFishTypes(budget - currentFish.getCost(), index + 1, newNewFishTypes));

                if(maxFishTypesWithoutCurrentFish.size() > maxFishTypesWithCurrentFish.size() ){
                    maxFishTypes = new ArrayList<Fish>(maxFishTypesWithoutCurrentFish);
                } else{

                    maxFishTypes = new ArrayList<Fish>(maxFishTypesWithCurrentFish);
                }
            }
        }
        printList(maxFishTypes);
        return maxFishTypes;
    }
	**/

    /**
	private void printList(List<Fish> fishList){
        //System.out.println("-------------------------------------------------\n");
        for(Fish f : fishList){
            System.out.println(f.getName());
            
        }
    }
	**/
}
