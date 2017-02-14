package main.items;

import main.exceptions.*;
import main.io.DataFileReader;
import main.utils.DataFormatValidator;

/**
 * Class Name: Journey.java
 * 
 * Description: This class creates Journey objects with the data taken
 * 				from the file journey.txt
 * 
 * @author George Goniotakis
 * @since Feb 9, 2017
 */

public class Journey {

	private String taxiRegistrationNumber; //Taxi`s registration number
	private int destinationID; //Destination`s ID
	private int numberOfPassengers; //Number of passengers
	private double time; //Journey`s total duration
	private double maximumVelocity; //Journey`s maximum velocity
	
	/**
	 * This constructor creates Journey objects using the parameters
	 * that can found below.
	 * 
	 * @exception InvalidIDException If the journey`s ID invalid id show an error
	 * @exception InvalidTaxiNameException If the taxi`s name is invalid show an error message 
	 * @exception InvalidBrandNameException If the taxi`s brand name is invalid show an error message
	 * @exception InvalidTimeException If the journey`s duration is invalid show an error message
	 * @exception InvalidMaximumVelocityException If the journey`s maximum velocity is invalid show an error message
	 * 
	 * @param destinationID Destination`s ID
	 * @param taxiRegistrationNumber Taxi`s registration number
	 * @param numberOfPassengers Number of passengers
	 * @param time Journey`s duration
	 * @param maximumVelocity Journey`s maximum velocity
	 */
	public Journey(int destinationID, String taxiRegistrationNumber, 
			int numberOfPassengers, double time, double maximumVelocity){
			
		this.destinationID = destinationID;
		this.taxiRegistrationNumber = taxiRegistrationNumber;
		this.numberOfPassengers = numberOfPassengers;
		this.time = time;
		this.maximumVelocity = maximumVelocity;
		
		try{
			
			if ( !DataFormatValidator.validateDestinationID(destinationID)) 
				throw new InvalidIDException(DataFileReader.FILE_NAME_JOURNEYS, DataFileReader.line_counter);
				
			if ( !DataFormatValidator.validateRegistrationNumber(taxiRegistrationNumber)) 
				throw new InvalidTaxiNameException(DataFileReader.FILE_NAME_JOURNEYS, DataFileReader.line_counter);
				
			if ( !DataFormatValidator.validatePassengerNumber(numberOfPassengers))		
				throw new InvalidBrandNameException(DataFileReader.FILE_NAME_JOURNEYS, DataFileReader.line_counter);	
			
			if ( !DataFormatValidator.validateTime(time))		
				throw new InvalidTimeException(DataFileReader.FILE_NAME_JOURNEYS, DataFileReader.line_counter);
			
			if ( !DataFormatValidator.validateMaximumVelocity(maximumVelocity))		
				throw new InvalidMaximumVelocityException(DataFileReader.FILE_NAME_JOURNEYS, DataFileReader.line_counter);
			
			
		} catch(InvalidIDException | InvalidTaxiNameException |
				InvalidBrandNameException | InvalidTimeException 
				| InvalidMaximumVelocityException e){
			
			System.out.println(e.getMessage()); //Show error message
			
		}
	}
	
	/**
	 * This method returns the information about a journey in
	 * one line.
	 * 
	 * return String
	 */
	@Override
	public String toString() {
		return "Journey{" +
				"taxiRegistrationNumber='" + taxiRegistrationNumber + '\'' +
				", destinationID=" + destinationID +
				", numberOfPassengers=" + numberOfPassengers +
				", time=" + time +
				", maximumVelocity=" + maximumVelocity +
				'}';
	}
	
	/* Getters and Setters */
	
	public String getTaxiRegistrationNumber() {
		return taxiRegistrationNumber;
	}

	public void setTaxiRegistrationNumber(String taxiRegistrationNumber) {
		this.taxiRegistrationNumber = taxiRegistrationNumber;
	}

	public int getDestinationID() {
		return destinationID;
	}

	public void setDestinationID(int destinationID) {
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

