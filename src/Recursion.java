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

        if(budget < 0 || index >= fishTypes.size()){
            return new ArrayList<Fish>();
        }
        Fish currentFish = fishTypes.get(index);
        List<Fish> maxFishTypes;

        //aktueller Fisch ist zu teuer fuer Restbudget, also wird der naechste Fisch ausprobiert
        if(currentFish.getCost() > budget){
            maxFishTypes = findMaxFishTypes(budget, index + 1, selectedFishTypes);
        } 
        //aktueller Fisch passt ins Restbudget
        else {
            //schauen, ob aktueller Fisch mit bisherigen Fischen kompatibel ist
            boolean isCompatible = true;
            for(Fish incompatibleFish : fishTypes.get(index).getIncompatibleTypes()){
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
                selectedFishTypes.add(currentFish);
                List<Fish> maxFishTypesWithCurrentFish;
                
                maxFishTypesWithCurrentFish = findMaxFishTypes(budget - currentFish.getCost(), index + 1, selectedFishTypes);

                if(maxFishTypesWithoutCurrentFish.size() > maxFishTypesWithCurrentFish.size() + 1){
                    maxFishTypes = maxFishTypesWithoutCurrentFish;
                } else{
                    maxFishTypes = maxFishTypesWithCurrentFish;
                }
            }
        }
        return maxFishTypes;
    }


}
