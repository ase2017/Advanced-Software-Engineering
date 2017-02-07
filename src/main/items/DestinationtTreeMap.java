package main.items;

import java.util.TreeMap;

public class DestinationtTreeMap {
	
	private TreeMap<Integer, Destination> destinations;
	
	public DestinationtTreeMap(TreeMap<Integer, Destination> destinations){
	
		this.destinations = destinations;
		
	}
	
	public void addDestination(Destination destination){
		
		destinations.put(destination.getDestinationID(), destination);
		
	}
	
	/* Getters and Setters */
	
	public TreeMap<Integer, Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(TreeMap<Integer, Destination> destinations) {
		this.destinations = destinations;
	}
	
	

}
