package items;
import java.util.ArrayList;
import java.util.HashMap;

public class TaxiData {

	private HashMap<String,Taxi> taxis;
	private ArrayList<Destination> currentYearDestinations;
	private ArrayList<Destination> previousYearDestinations;
	private ArrayList<Destination> journeys;
	
	
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
	
	private ArrayList<Taxi> findJourneys(Taxi taxi){
		
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
	
	public HashMap<String, Taxi> getTaxis() {
		return taxis;
	}
	public void setTaxis(HashMap<String, Taxi> taxis) {
		this.taxis = taxis;
	}
	public ArrayList<Destination> getCurrentYearDestinations() {
		return currentYearDestinations;
	}
	public void setCurrentYearDestinations(ArrayList<Destination> currentYearDestinations) {
		this.currentYearDestinations = currentYearDestinations;
	}
	public ArrayList<Destination> getPreviousYearDestinations() {
		return previousYearDestinations;
	}
	public void setPreviousYearDestinations(ArrayList<Destination> previousYearDestinations) {
		this.previousYearDestinations = previousYearDestinations;
	}
	public ArrayList<Destination> getJourneys() {
		return journeys;
	}
	public void setJourneys(ArrayList<Destination> journeys) {
		this.journeys = journeys;
	}
	
	
}
