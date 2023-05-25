package fische;
import java.util.ArrayList;
import java.util.List;

public class Fish {
    private String name;
    private int cost;
    private List<Fish> incompatibleTypes;
    
    Fish(String name, int cost){
        this.name = name;
        this.cost = cost;
        incompatibleTypes = new ArrayList<Fish>();
    }

    public String getName(){
        return name;
    }
    public int getCost(){
        return cost;
    }
    public List<Fish> getIncompatibleTypes(){
        return incompatibleTypes;
    }

    public void addIncompatibleType(Fish fish){
        incompatibleTypes.add(fish);
    }
}
