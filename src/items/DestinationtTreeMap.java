package items;

import java.util.TreeMap;

public class DestinationtTreeMap {
	
	private TreeMap<String, Destination> destinations;
	
	public DestinationtTreeMap(TreeMap<String, Destination> destinations){
	
		this.destinations = destinations;
		
	}

	
	/* Getters and Setters */
	
	public TreeMap<String, Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(TreeMap<String, Destination> destinations) {
		this.destinations = destinations;
	}
	
	

}
