package items;

import java.util.ArrayList;
import java.util.TreeMap;

public class TaxiData {

	private TreeMap<String,Taxi> taxis;
	private TreeMap<String, Destination> currentYearDestinations;
	private TreeMap<String, Destination> previousYearDestinations;
	private TreeMap<String, ArrayList<Journey>> journeys;
	
	
	public String formatInfoLine(Taxi taxi, Destination destination, Journey journey){
		
		return null;
	}
	
	public String formatMostExpensiveJourneys(int numberOfJourneys){
		
		return null;
	}
	
	public String formatLessExpensiveJourneys(int numberOfJourneys){
		
		return null;
	}
	
	private String calculateFee(){
		
		return null;
	}
	
	private Journey getTopNJourney(int number, boolean expensive){
		
		return null;
	}
	
	private Taxi findTaxi(Journey journey){
		
		return null;
	}
	
	private Destination findDestination(Journey journey){
		
		return null;
	}
	
	public String formatPlacesVisitedPerDriver(){
		
		return null;
	}
	
	private ArrayList<Journey> findJourneys(Taxi taxi){
		
		return null;
	}
	
	public String formatPlacesVisited(){
		
		return null;
	}
	
	private String formatCurrentYearVisitedPlaces(){
		
		return null;
	}
	
	private String formatPreviousYearVisitedPlaces(){
		
		return null;
	}
	
	private String formatPlacesVisitedInBothYears(){
		
		return null;
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
