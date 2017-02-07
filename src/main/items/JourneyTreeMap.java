package main.items;

import java.util.ArrayList;
import java.util.TreeMap;

public class JourneyTreeMap {
	
	private TreeMap<Integer, ArrayList<Journey>> journeys;
	
	public JourneyTreeMap(TreeMap<Integer, ArrayList<Journey>> journeys){
		
		this.journeys = journeys;
		
	}
	public void addJourney(Journey journey) {
		
		if(journeys.containsKey(journey.getRegistrationNumber())) {
			journeys.get(journey.getRegistrationNumber()).add(journey);
		} else {
			ArrayList<Journey> temporary = new ArrayList<>();
			temporary.add(journey);
			journeys.put(journey.getDestinationID(), temporary);
		}
	}

	public void addJourney(ArrayList<Journey> journey){
	
		for(int i = 0; i < journey.size(); i++){
			journeys.put(journey.get(i).getDestinationID(), journey);
		}
		
	}

	/* Getters and Setters */
	
	public TreeMap<Integer, ArrayList<Journey>> getJourneys() {
		return journeys;
	}

	public void setJourneys(TreeMap<Integer, ArrayList<Journey>> journeys) {
		this.journeys = journeys;
	}

}
