package items;

import java.util.TreeMap;

public class DestinationtTreeMap {
	
	private TreeMap<String, Destination> destinations;
	
	public DestinationtTreeMap(TreeMap<String, Destination> destinations){
	
		this.destinations = destinations;
		
	}

	
	public void addDestination(Destination destination){
		
		destinations.put(destination.getName(), destination);
		
	}
	
	/* Getters and Setters */
	
	public TreeMap<String, Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(TreeMap<String, Destination> destinations) {
		this.destinations = destinations;
	}
	
	

}
