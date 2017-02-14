package main.items;
import java.util.TreeSet;

/**
 * Used for 2016 Destination objects
 */
public class DestinationTreeSet {
    TreeSet<Destination> destinations;

    public DestinationTreeSet(TreeSet<Destination> destinations) {
        this.destinations = destinations;
    }
    public TreeSet<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(TreeSet<Destination> destinations) {
        this.destinations = destinations;
    }


    public boolean containsDestinationName(Destination destination) {

        if(destination == null) {
            throw new IllegalArgumentException("Destination is null");
        }
        //System.out.println("DESTINATION :" + destination.getDestinationName());
        for(Destination d : destinations) {
            //System.out.println("COMPARING IT TO : " + d.getDestinationName());
            if(d.getDestinationName().equals(destination.getDestinationName())) {
                //System.out.println("\n");
                //System.out.println("FOUND");
                return true;
            }


        }
        //System.out.println("NOT FOUND");
        return false;
    }

    public void add(Destination destination) {
        destinations.add(destination);
    }
}
