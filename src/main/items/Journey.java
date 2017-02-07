package main.items;

import main.exceptions.InvalidBrandNameException;
import main.exceptions.InvalidIDException;
import main.exceptions.InvalidMaximumVelocityException;
import main.exceptions.InvalidTimeException;
import main.io.DataFileReader;
import main.utils.DataFormatValidator;

public class Journey {

	private String registrationNumber;
	private Integer destinationID;
	private int numberOfPassengers;
	private double time;
	private double maximumVelocity;
	
	public Journey(Integer destinationID, String registrationNumber, 
			int numberOfPassengers, double time, double maximumVelocity){
			
		this.destinationID = destinationID;
		this.registrationNumber = registrationNumber;
		this.numberOfPassengers = numberOfPassengers;
		this.time = time;
		this.maximumVelocity = maximumVelocity;
		
		try{
			
			if ( !DataFormatValidator.validateDestinationID(destinationID)) 
				throw new InvalidIDException(DataFileReader.FILE_NAME_JOURNEYS, DataFileReader.line_counter);
				
			if ( !DataFormatValidator.validateRegistrationNumber(registrationNumber)) 
				throw new InvalidIDException(DataFileReader.FILE_NAME_JOURNEYS, DataFileReader.line_counter);
				
			if ( !DataFormatValidator.validatePassengerNumber(numberOfPassengers))		
				throw new InvalidBrandNameException(DataFileReader.FILE_NAME_JOURNEYS, DataFileReader.line_counter);	
			
			if ( !DataFormatValidator.validateTime(time))		
				throw new InvalidTimeException(DataFileReader.FILE_NAME_JOURNEYS, DataFileReader.line_counter);
			
			if ( !DataFormatValidator.validateMaximumVelocity(maximumVelocity))		
				throw new InvalidMaximumVelocityException(DataFileReader.FILE_NAME_JOURNEYS, DataFileReader.line_counter);
			
			
		} catch( InvalidIDException | InvalidBrandNameException | InvalidTimeException 
				| InvalidMaximumVelocityException e){
			
			System.out.println(e.getMessage());
			
		}
	}
	
	
	
	/* Getters and Setters */
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String taxiRegistrationNumber) {
		this.registrationNumber = taxiRegistrationNumber;
	}

	public int getDestinationID() {
		return destinationID;
	}

	public void setDestinationID(Integer destinationID) {
		this.destinationID = destinationID;
	}

	public Integer getNumberOfPassengers() {
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

