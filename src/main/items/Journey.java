package main.items;

import main.exceptions.InvalidBrandNameException;
import main.exceptions.InvalidDestinationNameException;
import main.exceptions.InvalidMaximumVelocityException;
import main.exceptions.InvalidTaxiNameException;
import main.exceptions.InvalidTimeException;
import main.io.DataFileReader;
import main.utils.DataFormatValidator;

public class Journey {

	private String taxiRegistrationNumber;
	private int destinationID;
	private int numberOfPassengers;
	private double time;
	private double maximumVelocity;
	
	public Journey(int destinationID, String taxiRegistrationNumber, 
			int numberOfPassengers, double time, double maximumVelocity){
			
		this.destinationID = destinationID;
		this.taxiRegistrationNumber = taxiRegistrationNumber;
		this.numberOfPassengers = numberOfPassengers;
		this.time = time;
		this.maximumVelocity = maximumVelocity;
		
		try{
			
			if ( !DataFormatValidator.validateDestinationID(destinationID)) 
				throw new InvalidDestinationNameException(DataFileReader.FILE_NAME_JOURNEYS, DataFileReader.line_counter);
				
			if ( !DataFormatValidator.validateRegistrationNumber(taxiRegistrationNumber)) 
				throw new InvalidTaxiNameException(DataFileReader.FILE_NAME_JOURNEYS, DataFileReader.line_counter);
				
			if ( !DataFormatValidator.validatePassengerNumber(numberOfPassengers))		
				throw new InvalidBrandNameException(DataFileReader.FILE_NAME_JOURNEYS, DataFileReader.line_counter);	
			
			if ( !DataFormatValidator.validateTime(time))		
				throw new InvalidTimeException(DataFileReader.FILE_NAME_JOURNEYS, DataFileReader.line_counter);
			
			if ( !DataFormatValidator.validateMaximumVelocity(maximumVelocity))		
				throw new InvalidMaximumVelocityException(DataFileReader.FILE_NAME_JOURNEYS, DataFileReader.line_counter);
			
			
		} catch(InvalidDestinationNameException | InvalidTaxiNameException | 
				InvalidBrandNameException | InvalidTimeException 
				| InvalidMaximumVelocityException e){
			
			System.out.println(e.getMessage());
			
		}
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

