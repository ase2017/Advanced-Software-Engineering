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


}
