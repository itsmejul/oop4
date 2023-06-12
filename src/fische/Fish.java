package fische;
import java.util.List;
/**
 * Fish-Klasse enthaelt die Attribute der Fische
 * @author Simon Hoffmann und Julian Mosig von Aehrenfeld
 *
 */
public class Fish {
    private String name;
    private int cost;
    private List<String> incompatibleTypes;
    /**
     * Konstruktor
     * @param name Name vom Fisch
     * @param cost Kosten vom Fisch
     * @param incompatibleTypes Liste von inkompatiblen Fischen
     */
    Fish(String name, int cost, List<String> incompatibleTypes){
        this.name = name;
        this.cost = cost;
        this.incompatibleTypes = incompatibleTypes;
    }
    /**
     * Methode gibt den Fischnamen wieder
     * @return Fischname
     */
    public String getName(){
        return name;
    }
    /**
     * Methode gibt die Kosten fuer den Fisch wieder 
     * @return Kosten vom Fisch
     */
    public int getCost(){
        return cost;
    }
    /**
     * Methode gibt eine Liste von inkompatiblen Fischen
     * @return Liste mit Namen von inkompatiblen Fischen
     */
    public List<String> getIncompatibleTypes(){
        return incompatibleTypes;
    }
    /**
     * Methode fuegt einen Fischname auf die List fuer inkompatible Fisch hinzu
     */
    public void addIncompatibleType(String fishName){
        incompatibleTypes.add(fishName);
    }
    /**
     * Methode prueft den Parameter auf Inkompatiblitaet
     * @param fishName Name des Fisches
     * @return Wahrheitswert
     */
    public boolean isIncompatible(String fishName) {
    	return incompatibleTypes.contains(fishName);
    }
}
