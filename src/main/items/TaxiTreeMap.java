package main.items;

import java.util.TreeMap;
import main.exceptions.DuplicateIDException;
import main.io.DataFileReader;

/**
 * Class Name: TaxiTreeMap.java
 * 
 * Description: This class creates a TreeMap in order to store
 * 				taxi Objects.
 * 
 * @author George Goniotakis
 * @since Feb 9, 2017
 */

public class TaxiTreeMap {
	
	private TreeMap<String, Taxi> taxis; //The TreeMap that contains the taxis

	/**
	 * This constructor creates a new TaxiTreeMap.
	 * 
	 * @param taxis TreeMap that contains all the taxis
	 */
	public TaxiTreeMap(TreeMap<String, Taxi> taxis){
		
		this.taxis = taxis;
		
	}

	/**
	 * Method that checks if a taxi with the same details already exists and
	 * if not it adds it in the TreeMap.
	 * 
	 * @exception DuplicateIDException If a taxi with the same ID already exists, show an error message
	 * 
	 * @param taxi The taxi object that we want to push
	 */
	public void addTaxi(Taxi taxi){
		
		if(taxis.containsKey(taxi.getRegistrationNumber())){
			try {
				throw new DuplicateIDException(DataFileReader.FILE_NAME_TAXIS, DataFileReader.line_counter);
			} catch (DuplicateIDException e) {
				System.out.println(e.getMessage()); //Show error message
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
