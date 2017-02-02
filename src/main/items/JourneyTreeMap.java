package main.items;

import java.util.ArrayList;
import java.util.TreeMap;

public class JourneyTreeMap {
	
	private TreeMap<String, ArrayList<Journey>> journeys;
	
	public JourneyTreeMap(TreeMap<String, ArrayList<Journey>> journeys){
		
		this.journeys = journeys;
		
	}

	public void addJourney(ArrayList<Journey> journey){
	
		//TODO: Ask how is this going to be implemented?
		
		
		
	}
	
	
	/* Getters and Setters */
	
	public TreeMap<String, ArrayList<Journey>> getJourneys() {
		return journeys;
	}

	public void setJourneys(TreeMap<String, ArrayList<Journey>> journeys) {
		this.journeys = journeys;
	}

}
