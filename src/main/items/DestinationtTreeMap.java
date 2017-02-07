package main.items;

import java.util.TreeMap;

import main.exceptions.DuplicateIDException;
import main.io.DataFileReader;

public class DestinationtTreeMap {
	
	private TreeMap<Integer, Destination> destinations;
	
	public DestinationtTreeMap(TreeMap<Integer, Destination> destinations){
	
		this.destinations = destinations;
		
	}
	
	public void addDestination(Destination destination){
		
		if(destinations.containsKey(destination.getDestinationID())){
			try {
				throw new DuplicateIDException(DataFileReader.FILE_NAME_DESTINATIONS_2017, DataFileReader.line_counter);
			} catch (DuplicateIDException e) {
				System.out.println(e.getMessage());
			}
		} else {
			destinations.put(destination.getDestinationID(), destination);
		}
	}
	
	/* Getters and Setters */
	
	public TreeMap<Integer, Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(TreeMap<Integer, Destination> destinations) {
		this.destinations = destinations;
	}
	
	

}
