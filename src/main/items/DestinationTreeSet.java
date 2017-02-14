package main.items;

import java.util.TreeSet;

/**
 * Class Name: DestinationTreeSet.java
 * 
 * Description: This class creates a TreeSet that contains
 * 				all the destinations of 2016. 
 * 
 * @author George Goniotakis
 * @since Feb 9, 2017
 */


public class DestinationTreeSet {
	
    TreeSet<Destination> destinations; //TreeSet that keeps all the destinations

    /**
     * This constructor creates a TreeSet with all the destinations
     * of 2016.
     * 
     * @param destinations TreeSet with destinations
     */
    public DestinationTreeSet(TreeSet<Destination> destinations) {
        this.destinations = destinations;
    }
   
    /**
     * This method checks if the TreeSet already contains 
     * a destination with the same name.
     * 
     * @param destination
     * @return boolean true/false
     */
    public boolean containsDestinationName(Destination destination) {
     
        for(Destination d : destinations) {
            if(d.getDestinationName().equals(destination.getDestinationName())) {
                return true;
            }
        }

        return false;
    }
    
    /* Getters and Setters */
    public TreeSet<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(TreeSet<Destination> destinations) {
        this.destinations = destinations;
    }
}
