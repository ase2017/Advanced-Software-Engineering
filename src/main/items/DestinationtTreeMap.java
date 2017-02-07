package main.items;

import java.util.TreeMap;
import main.exceptions.DuplicateIDException;
import main.io.DataFileReader;

public class DestinationtTreeMap {
	
	private TreeMap<Integer, Destination> destinations;
	
	public DestinationtTreeMap(TreeMap<Integer, Destination> destinations){
	
		this.destinations = destinations;
		
	}
	
	public void addDestination2016(Destination destination){

		destinations.put(destination.getDestinationID(), destination);

	}

	public void addDestination2017(Destination destination) throws DuplicateIDException{

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

	public boolean containsDestinationName(Destination destination) {
		//System.out.println("DESTINATION :" + destination.getDestinationName());
		for(Destination d : destinations.values()) {
			//System.out.println("COMPARING IT TO : " + d.getDestinationName());
			if(d.getDestinationName().equals(destination.getDestinationName())){
				//System.out.println("\n");
				return true;
			}
		}
		return false;
	}
	
	/* Getters and Setters */
	
	public TreeMap<Integer, Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(TreeMap<Integer, Destination> destinations) {
		this.destinations = destinations;
	}
	
	

}
