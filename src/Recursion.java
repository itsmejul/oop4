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
        System.out.println(budget + "-----" + index + "\n");
        printList(selectedFishTypes);
        if(budget < 0 || index >= fishTypes.size()){
            
            return new ArrayList<Fish>();
        }
        Fish currentFish = fishTypes.get(index);
        List<Fish> maxFishTypes;

        if(selectedFishTypes.contains(currentFish)){
            return findMaxFishTypes(budget, index + 1, selectedFishTypes);
        }

        //aktueller Fisch ist zu teuer fuer Restbudget, also wird der naechste Fisch ausprobiert
        if(currentFish.getCost() > budget){
            maxFishTypes = findMaxFishTypes(budget, index + 1, selectedFishTypes);
        } 
        //aktueller Fisch passt ins Restbudget
        else {
            //schauen, ob aktueller Fisch mit bisherigen Fischen kompatibel ist
            boolean isCompatible = true;
            for(Fish incompatibleFish : currentFish.getIncompatibleTypes()){
                if(selectedFishTypes.contains(incompatibleFish)){
                    isCompatible = false;
                } 
            }
            //aktueller Fisch ist nicht kompatibel, betrachte naechsten moeglichen Fisch
            if(!isCompatible){
                maxFishTypes = findMaxFishTypes(budget, index + 1, selectedFishTypes);
            } 
            //aktueller Fisch ist kompatibel und passt ins Budget
            else{
                
                List<Fish> maxFishTypesWithoutCurrentFish;
                maxFishTypesWithoutCurrentFish = findMaxFishTypes(budget, index + 1, selectedFishTypes);
                
                List<Fish> newFishTypes = new ArrayList<Fish>(selectedFishTypes);
                newFishTypes.add(currentFish);
                List<Fish> maxFishTypesWithCurrentFish;
                
                maxFishTypesWithCurrentFish = findMaxFishTypes(budget - currentFish.getCost(), index + 1, newFishTypes);

                if(maxFishTypesWithoutCurrentFish.size() > maxFishTypesWithCurrentFish.size() ){
                    maxFishTypes = maxFishTypesWithoutCurrentFish;
                } else{

                    maxFishTypes = maxFishTypesWithCurrentFish;
                }
            }
        }
        return maxFishTypes;
    }


    private void printList(List<Fish> fishList){
        System.out.println("-------------------------------------------------\n");
        for(Fish f : fishList){
            System.out.println(f.getName());
            
        }
    }

}
