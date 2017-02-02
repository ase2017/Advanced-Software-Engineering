package main.items;

import exceptions.InvalidBrandNameException;
import exceptions.InvalidDestinationNameException;
import exceptions.InvalidMaximumVelocityException;
import exceptions.InvalidTaxiNameException;
import exceptions.InvalidTimeException;
import io.DataFileReader;
import utils.DataFormatValidator;

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
		
		try{
			
			if ( !DataFormatValidator.validateDestinationName(destinationID)) 
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

