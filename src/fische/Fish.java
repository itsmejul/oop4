package fische;
import java.util.List;

public class Fish {
    private String name;
    private int cost;
    private List<String> incompatibleTypes;
    
    Fish(String name, int cost, List<String> incompatibleTypes){
        this.name = name;
        this.cost = cost;
        this.incompatibleTypes = incompatibleTypes;
    }

    public String getName(){
        return name;
    }
    public int getCost(){
        return cost;
    }
    public List<String> getIncompatibleTypes(){
        return incompatibleTypes;
    }
    public void addIncompatibleType(String fish){
        incompatibleTypes.add(fish);
    }
    public boolean isIncompatible(String fish) {
    	return incompatibleTypes.contains(fish);
    }
}
