import java.util.ArrayList;
import java.util.List;

public class Recursion {
    private List<Fish> fishTypes;
    private int budget;

    Recursion(List<Fish> fishTypes, int budget){
        this.fishTypes = fishTypes;
        this.budget = budget;
    }

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
            return findMaxFishTypes(budget, index + 1, newFishTypes);
        }

        //aktueller Fisch ist zu teuer fuer Restbudget, also wird der naechste Fisch ausprobiert
        if(currentFish.getCost() > budget){
            maxFishTypes = findMaxFishTypes(budget, index + 1, newFishTypes);
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
                maxFishTypes = findMaxFishTypes(budget, index + 1, newFishTypes);
            } 
            //aktueller Fisch ist kompatibel und passt ins Budget
            else{
                
                List<Fish> maxFishTypesWithoutCurrentFish;
                maxFishTypesWithoutCurrentFish = findMaxFishTypes(budget, index + 1, newFishTypes);
                
                List<Fish> newNewFishTypes = new ArrayList<Fish>(selectedFishTypes);
                newNewFishTypes.add(currentFish);
                List<Fish> maxFishTypesWithCurrentFish;
                
                maxFishTypesWithCurrentFish = findMaxFishTypes(budget - currentFish.getCost(), index + 1, newNewFishTypes);

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


    private void printList(List<Fish> fishList){
        System.out.println("-------------------------------------------------\n");
        for(Fish f : fishList){
            System.out.println(f.getName());
            
        }
    }

}
