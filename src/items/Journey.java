
package items;

public class Journey {

	private String taxiRegistrationNumber;
	private String destinationName;
	private int numberOfPassengers;
	private double time;
	private double maximumVelocity;
	
	public Journey(String taxiRegistrationNumber, String destinationName, int numberOfPassengers, double time, double maximumVelocity){
		
		this.taxiRegistrationNumber = taxiRegistrationNumber;
		this.destinationName = destinationName;
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

