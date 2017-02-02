package items;

import java.util.*;

public class TaxiData {

	private TreeMap<String,Taxi> taxis;
	private TreeMap<String, Destination> currentYearDestinations;
	private TreeMap<String, Destination> previousYearDestinations;
	private TreeMap<String, ArrayList<Journey>> journeys;


	/**
	 * Formats and returns a line of information for the first output file (top 5 journeys)
	 * @param taxi
	 * @param destination
	 * @param journey
     * @return
     */
	public String formatInfoLine(Taxi taxi, Destination destination, Journey journey){

		String res = "";
		if(taxi != null && destination != null && journey != null) {
			res += journey.getTaxiRegistrationNumber() + "   "
					+ destination.getDestinationName() + "   "
					+ destination.getDistance() + " miles   "
					+ journey.getNumberOfPassengers() + "   "
					+ "Cost £" + calculateFee(journey)
					+ "\n";
		}
		return null;
	}

	/**
	 * Formats and returns the top most expensive given number of journeys
	 * @param numberOfJourneys : the number of top journeys that we are interested in
	 * @return
	 */
	public String formatMostExpensiveJourneys(int numberOfJourneys){

		String result = "";

		if(numberOfJourneys <= 0) {
			result = "Invalid input number of journeys.";
		} else {
			if (journeys.size() == 0) {
				result = "There was no journey in our records.";
			} else {

				/*
				// Need to store them because we need to check that there are no duplicates
				 */
				TreeMap<Double,ArrayList<Journey>> sortedJourneysByPrice = getJourneysByPrice();
				ArrayList<Journey> topNjourneys = new ArrayList<>();

				Iterator it = sortedJourneysByPrice.entrySet().iterator();

				if(numberOfJourneys <= journeys.size()) {
					result = "CHARGES FOR THE TOP " + numberOfJourneys + " JOURNEYS\n";

					while(it.hasNext() && topNjourneys.size() < numberOfJourneys) {
						ArrayList<Journey> temporaryJourneyArrayList = (ArrayList<Journey>)it.next();
						for (Journey j : temporaryJourneyArrayList) {
							if(topNjourneys.size() < numberOfJourneys) {
								topNjourneys.add(j);
							}
						}
					}

					// If the parameter is bigger than the number of stored journeys, we stop to the number of stored journeys
				} else {
					result = "CHARGES FOR THE TOP " + journeys.size() + " JOURNEYS\n";

					while(it.hasNext() && topNjourneys.size() < journeys.size()) {
						ArrayList<Journey> temporaryJourneyArrayList = (ArrayList<Journey>)it.next();
						for (Journey j : temporaryJourneyArrayList) {
							if(topNjourneys.size() < journeys.size()) {
								topNjourneys.add(j);
							}
						}
					}
				}


				for(Journey j : topNjourneys) {
					Destination dest = findDestination(j);
					Taxi tx = findTaxi(j);
					result += formatInfoLine(tx,dest,j);
				}

			}
		}

		return result;
	}

	/**
	 * Formats and returns the top least expensive given number of journeys
	 * @param numberOfJourneys
	 * @return
     */
	public String formatLessExpensiveJourneys(int numberOfJourneys){

		return null;
	}

	private double calculateFee(Journey journey){

		return 55;
	}

	/**
	 * Returns a treemap of arraylist of journeys, with keys being the price
	 * @return
     */
	private TreeMap<Double,ArrayList<Journey>> getJourneysByPrice() {

		TreeMap<Double,ArrayList<Journey>> topNJourneysWithSamePrice = new TreeMap<>();
		for(Map.Entry<String,ArrayList<Journey>> entry : journeys.entrySet()) {
			for(Journey j : entry.getValue()) {
				if(topNJourneysWithSamePrice.containsKey(calculateFee(j))) {
					topNJourneysWithSamePrice.get(calculateFee(j)).add(j);
				} else {
					ArrayList<Journey> tmpJourneys = new ArrayList<>();
					topNJourneysWithSamePrice.put(calculateFee(j),tmpJourneys);
					topNJourneysWithSamePrice.get(calculateFee(j)).add(j);
				}

			}

		}

		return topNJourneysWithSamePrice;
	}


	/**
	 * Finds and returns the taxi associated to the given journey
	 * @param journey
	 * @return
     */
	private Taxi findTaxi(Journey journey){

		if(journey != null && taxis != null && taxis.containsKey(journey.getTaxiRegistrationNumber())) {
			return (taxis.get(journey.getTaxiRegistrationNumber()));
		}

		return null;
	}

	/**
	 * Returns the destination object related to the given journey
	 * @param journey : the given journey
	 * @return the destination object related to the given journey
     */
	private Destination findDestination(Journey journey){

		if(journey != null && currentYearDestinations != null && currentYearDestinations.containsKey(journey.getDestinationID())) {
			return (currentYearDestinations.get(journey.getDestinationID()));
		}

		return null;
	}

	/**
	 * Formats the second file, which contains the list of places visited per driver, ordered alphabetically by driver name
	 * @return a String containing the content of the file
     */
	public String formatPlacesVisitedPerDriver(){

		String res = "";

		if(taxis != null && taxis.size() < 0) {
			TreeMap<String,ArrayList<Taxi>> sortedTaxi = sortTaxisByName();
			res = "PLACES VISITED PER DRIVER\n\n";

			// Each value of the tree map is an arraylist
			// TreeMap keySet is sorted alphabetically
			for(ArrayList<Taxi> subList : sortedTaxi.values()) {

				for(Taxi t : subList) {


					res += t.getDriverName() + "\n";

					ArrayList<Journey> journeysOfCurrentTaxi = findJourneys(t); //journeys of the driver

					if (journeysOfCurrentTaxi != null) {
						TreeSet<String> destinationNamesSorted = new TreeSet<String>(); //sorted distance name of the journeys of the driver

						// getting all distances done by driver
						for (Journey j : journeysOfCurrentTaxi) {
							Destination tmpDestination = findDestination(j);

							if (tmpDestination != null) {
								destinationNamesSorted.add(tmpDestination.getDestinationName());
							} else {
								System.out.println("No destinations were found in our records for given journey.\n");
							}

						}

						// building up the result
						for (String destinationName : destinationNamesSorted) {
							res += "\t " + destinationName + "\n";
						}
					} else {
						System.out.println("No journeys were found in our records for given taxi.\n");
					}

				}
				res += "\n"; //separation between each taxi

			}
			res += "\n\n";
		} else {
			res = "No places were found in our records.\n";
		}

		return res;
	}

	/**
	 * Sorts the taxis by name and returns an treemap of arralylists of them
	 * @return
     */
	public TreeMap<String,ArrayList<Taxi>> sortTaxisByName() {

		TreeMap<String,ArrayList<Taxi>> sortedTaxiTreeMap = new TreeMap<String,ArrayList<Taxi>>();

		if(taxis != null && taxis.size() > 0) {
			for(Map.Entry<String,Taxi> mapItem : taxis.entrySet()) {

				// handles if more at least one other driver has same name
				if(sortedTaxiTreeMap.containsKey(mapItem.getKey())) {
					sortedTaxiTreeMap.get(mapItem.getKey()).add(mapItem.getValue());
				// if key does not exist, create new key-value pair
				} else {
					ArrayList<Taxi> temporary = new ArrayList<Taxi>();
					temporary.add(mapItem.getValue());
					sortedTaxiTreeMap.put(mapItem.getKey(),temporary);
				}

			}
		}

		return sortedTaxiTreeMap;
	}

	/**
	 * Returns the list of journeys made by a given taxi for the current year
	 * @param taxi : the given taxi
	 * @return an arraylist of the journeys made by the given taxi
	 */
	private ArrayList<Journey> findJourneys(Taxi taxi){

		if(taxi != null && journeys != null && journeys.containsKey(taxi.getRegistrationNumber())) {
			return (journeys.get(taxi.getRegistrationNumber()));
		}

		return null;
	}

	/**
	 * Formats the content of file number 3, which contains the places visited per year and in both years
	 * @return a String of the content to be put in the third file
     */
	public String formatPlacesVisited(){

		String res = "";

		if(previousYearDestinations!= null && previousYearDestinations.size() > 0
				&& currentYearDestinations != null && currentYearDestinations.size() > 0) {

			TreeSet<String> currentYearVisitedPlacesSet  = new TreeSet<>();
			TreeSet<String> previousYearVisitedPlacesSet  = new TreeSet<>();
			TreeSet<String> placesVisitedInBothYearsSet  = new TreeSet<>();

			for(Destination l : currentYearDestinations.values()) {
				if(previousYearDestinations.values().contains(l)) {
					placesVisitedInBothYearsSet.add(l.getDestinationName());
				} else {
					currentYearVisitedPlacesSet.add(l.getDestinationName());
				}
			}

			for(Destination l : previousYearDestinations.values()) {
				if(currentYearDestinations.values().contains(l)) {
					// do nothing, it's already added in previous loop
				} else {
					previousYearVisitedPlacesSet.add(l.getDestinationName());
				}
			}

			res += formatCurrentYearVisitedPlaces(currentYearVisitedPlacesSet)
					+ formatPreviousYearVisitedPlaces(previousYearVisitedPlacesSet)
					+ formatPlacesVisitedInBothYears(placesVisitedInBothYearsSet);

		} else {
			res = "At least one destinations file was empty";
		}

		return res;
	}

	/**
	 * Formats and returns the first part of the third file about destinations per year
	 * @param currentYearVisitedPlacesSet
	 * @return
     */
	private String formatCurrentYearVisitedPlaces(TreeSet<String> currentYearVisitedPlacesSet){

		String res = "";

		if(currentYearVisitedPlacesSet != null && currentYearVisitedPlacesSet.size() > 0) {
			res = currentYearVisitedPlacesSet.size() + "NEW PLACES IN 2017\n";

			for(String str : currentYearVisitedPlacesSet) {
				res += str + "\n";
			}
			res += "\n";
		} else {
			res = "Sorry, no destinations were found in our record of current year";
		}

		return res;
	}


	/**
	 * Formats and returns the second part of the third file about destinations per year
	 * @param previousYearVisitedPlacesSet
	 * @return
	 */
	private String formatPreviousYearVisitedPlaces(TreeSet<String> previousYearVisitedPlacesSet){

		String res = "";

		if(previousYearVisitedPlacesSet != null && previousYearVisitedPlacesSet.size() > 0) {
			res = previousYearVisitedPlacesSet.size() + "PLACES VISITED IN 2017 ONLY\n";

			for(String str : previousYearVisitedPlacesSet) {
				res += str + "\n";
			}
			res += "\n";

		} else {
			res = "Sorry, no destinations were found in our record of previous year";
		}

		return res;
	}


	/**
	 * Formats and returns the third part of the third file about destinations per year
	 * @param placesVisitedInBothYearsSet
	 * @return
	 */
	private String formatPlacesVisitedInBothYears(TreeSet<String> placesVisitedInBothYearsSet){

		String res = "";

		if(placesVisitedInBothYearsSet != null && placesVisitedInBothYearsSet.size() > 0) {
			res = placesVisitedInBothYearsSet.size() + "PLACES VISITED IN BOTH 2017 AND 2016\n";

			for(String str : placesVisitedInBothYearsSet) {
				res += str + "\n";
			}
			res += "\n";

		} else {
			res = "Sorry, no destinations were found in our record of both current and previous years";
		}

		return res;
	}
	
	
	/* Getters and Setters */

	public TreeMap<String, Taxi> getTaxis() {
		return taxis;
	}
	public void setTaxis(TreeMap<String, Taxi> taxis) {
		this.taxis = taxis;
	}
	public TreeMap<String, Destination> getCurrentYearDestinations() {
		return currentYearDestinations;
	}
	public void setCurrentYearDestinations(TreeMap<String, Destination> currentYearDestinations) {
		this.currentYearDestinations = currentYearDestinations;
	}
	public TreeMap<String, Destination> getPreviousYearDestinations() {
		return previousYearDestinations;
	}
	public void setPreviousYearDestinations(TreeMap<String, Destination> previousYearDestinations) {
		this.previousYearDestinations = previousYearDestinations;
	}
	public TreeMap<String, ArrayList<Journey>> getJourneys() {
		return journeys;
	}
	public void setJourneys (TreeMap<String, ArrayList<Journey>> journeys) {
		this.journeys = journeys;
	}


}
