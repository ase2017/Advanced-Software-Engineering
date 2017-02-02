package main.items;

public class Destination {

	private int destinationID;
	private String name;
	private double distance;
	private boolean urban;
	
	public Destination(int destinationID, String name, double distance, boolean urban){
		
		this.destinationID = destinationID;
		this.name = name;
		this.distance = distance;
		this.urban = urban;
	}

	
	
	/* Getters and Setters */
	
	public int getDestinationID() {
		return destinationID;
	}

	public void setDestinationID(int destinationID) {
		this.destinationID = destinationID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public boolean isUrban() {
		return urban;
	}

	public void setUrban(boolean urban) {
		this.urban = urban;
	}

	
	
	
}

