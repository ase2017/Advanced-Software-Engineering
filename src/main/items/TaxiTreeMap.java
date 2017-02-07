package main.items;

import java.util.TreeMap;

import main.exceptions.DuplicateIDException;
import main.io.DataFileReader;

public class TaxiTreeMap {
	
	private TreeMap<String, Taxi> taxis;

	public TaxiTreeMap(TreeMap<String, Taxi> taxis){
		
		this.taxis = taxis;
		
	}

	public void addTaxi(Taxi taxi){
		
		if(taxis.containsKey(taxi.getRegistrationNumber())){
			try {
				throw new DuplicateIDException(DataFileReader.FILE_NAME_TAXIS, DataFileReader.line_counter);
			} catch (DuplicateIDException e) {
				System.out.println(e.getMessage());
			}
		} else {
			taxis.put(taxi.getRegistrationNumber(), taxi);
		}
		
	}
	
	/* Getters and Setters */
	
	public TreeMap<String, Taxi> getTaxis() {
		return taxis;
	}

	public void setTaxis(TreeMap<String, Taxi> taxis) {
		this.taxis = taxis;
	}
	
	
}
