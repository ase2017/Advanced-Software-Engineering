package main.items;

public class Journey {

	private String taxiRegistrationNumber;
	private String destinationID;
	private int numberOfPassengers;
	private double time;
	private double maximumVelocity;
	
	public Journey(String destinationID, String taxiRegistrationNumber, 
			int numberOfPassengers, double time, double maximumVelocity){
		
		
		this.destinationID = destinationID;
		this.taxiRegistrationNumber = taxiRegistrationNumber;
		this.numberOfPassengers = numberOfPassengers;
		this.time = time;
		this.maximumVelocity = maximumVelocity;
	}
	
	
	
	/* Getters and Setters */
	
	public String getTaxiRegistrationNumber() {
		return taxiRegistrationNumber;
	}

	public void setTaxiRegistrationNumber(String taxiRegistrationNumber) {
		this.taxiRegistrationNumber = taxiRegistrationNumber;
	}

	public String getDestinationID() {
		return destinationID;
	}

	public void setDestinationID(String destinationID) {
		this.destinationID = destinationID;
	}

	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}

	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public double getMaximumVelocity() {
		return maximumVelocity;
	}

	public void setMaximumVelocity(double maximumVelocity) {
		this.maximumVelocity = maximumVelocity;
	}
	

}

