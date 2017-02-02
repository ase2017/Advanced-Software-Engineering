package main.items;

import java.util.TreeMap;

public class TaxiTreeMap {
	
	private TreeMap<String, Taxi> taxis;

	public TaxiTreeMap(TreeMap<String, Taxi> taxis){
		
		this.taxis = taxis;
		
	}

	public void addTaxi(Taxi taxi){
		
		taxis.put(taxi.getRegistrationNumber(), taxi);
		
	}
	
	/* Getters and Setters */
	
	public TreeMap<String, Taxi> getTaxis() {
		return taxis;
	}

	public void setTaxis(TreeMap<String, Taxi> taxis) {
		this.taxis = taxis;
	}
	
	
}
