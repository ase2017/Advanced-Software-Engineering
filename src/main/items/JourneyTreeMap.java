package main.items;

import java.util.ArrayList;
import java.util.TreeMap;

public class JourneyTreeMap {
	
	private TreeMap<String, ArrayList<Journey>> journeys;
	
	public JourneyTreeMap(TreeMap<String, ArrayList<Journey>> journeys){
		
		this.journeys = journeys;
		
	}
	public void addJourney(Journey journey) {
		
		if(journeys.containsKey(journey.getTaxiRegistrationNumber())) {
			journeys.get(journey.getTaxiRegistrationNumber()).add(journey);
		} else {
			ArrayList<Journey> temporary = new ArrayList<>();
			temporary.add(journey);
			journeys.put(journey.getTaxiRegistrationNumber(), temporary);
		}
	}

	public void addJourney(ArrayList<Journey> journey){
	
		for(int i = 0; i < journey.size(); i++){
			journeys.put(journey.get(i).getTaxiRegistrationNumber(), journey);
		}
		
	}

	/* Getters and Setters */
	
	public TreeMap<String, ArrayList<Journey>> getJourneys() {
		return journeys;
	}

	public void setJourneys(TreeMap<String, ArrayList<Journey>> journeys) {
		this.journeys = journeys;
	}

}
