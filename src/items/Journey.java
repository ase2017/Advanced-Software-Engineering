package items;

public class Journey {
	private String taxiRegistrationNumber;
	private String destinationName;
	private int numberOfPassengers;
	
	public Journey(){
		
	}
	
	public Journey(String taxiRegistrationNumber, String destinationName, int numberOfPassengers) {
		this.taxiRegistrationNumber = taxiRegistrationNumber;
		this.destinationName = destinationName;
		this.numberOfPassengers = numberOfPassengers;
	}
	
	public String getTaxiRegistrationNumber() {
		return taxiRegistrationNumber;
	}
	public void setTaxiRegistrationNumber(String taxiRegistrationNumber) {
		this.taxiRegistrationNumber = taxiRegistrationNumber;
	}
	public String getDestinationName() {
		return destinationName;
	}
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}
	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}
	
	
}
