package main.items;

import main.exceptions.InvalidDestinationNameException;
import main.exceptions.InvalidDistanceException;
import main.io.DataFileReader;
import main.utils.DataFormatValidator;


/**
 * Class Name: Destination.java
 * 
 * Description: This class creates objects of destinations for
 *				the years 2016-2017. It includes two different
 *				constructors.
 * 
 * @author George Goniotakis
 * @since Feb 9, 2017
 */


public class Destination implements Comparable<Destination>{

	private int destinationID; //Destination`s ID
	private String destinationName; //Destination`s name
	private double distance; //Destination`s distance
	private boolean urban; //Destination`s urban / not urban

	/**
	 * This constructor creates a destination by using the parameters that
	 * are shown below. This constructor is used for destinations of 2017.
	 * 
	 * @exception InvalidDestinationNameException If destination`s name is invalid show error
	 * @exception InvalidDistanceException If destination`s distance is invalid show error
	 * 
	 * @param destinationID The destination`s ID
	 * @param destinationName The destination`s name
	 * @param distance The destination`s distance
	 * @param urban If the destination is urban/not urban
	 */
	public Destination(int destinationID, String destinationName, double distance, boolean urban){

		this.destinationID = destinationID;
		this.destinationName = destinationName;
		this.distance = distance;
		this.urban = urban;
		
		/* Checks */
		
		try{
			if ( !DataFormatValidator.validateDriverName(destinationName) ) 
				throw new InvalidDestinationNameException(DataFileReader.FILE_NAME_DESTINATIONS_2017, DataFileReader.line_counter);
						
			if ( !DataFormatValidator.validateDistance(distance) ) 
				throw new InvalidDistanceException(DataFileReader.FILE_NAME_DESTINATIONS_2017, DataFileReader.line_counter);
							
		} catch(InvalidDestinationNameException | InvalidDistanceException e){
			
			System.out.println(e.getMessage()); //Show the error message
			
		}	
		
		/* End of checks */
	}

	/**
	 * This constructor creates a destination by using the parameters that
	 * are shown below. This constructor is used for destinations of 2016.
	 *
	 * @exception InvalidDestinationNameException If the destination`s name is invalid show error
	 * @param destinationName The destination`s name
	 */
	public Destination(String destinationName){
		
		this.destinationName = destinationName;
		
		try{
			if ( !DataFormatValidator.validateDriverName(destinationName) ) 
				throw new InvalidDestinationNameException(DataFileReader.FILE_NAME_DESTINATIONS_2016, 0);
		}
		catch(InvalidDestinationNameException e){
			System.out.println(e.getMessage()); //Show error message
		}
	}
	
	/**
	 * This method is outputting information about the current
	 * destination in one line.
	 * 
	 * @return String The description of destination
	 */
	@Override
	public String toString() {
		if (destinationID == 0) {
			return "destinationName=" + destinationName;
		}

			return "Destination{" +
					"destinationID=" + destinationID +
					", destinationName='" + destinationName + '\'' +
					", distance=" + distance +
					", urban=" + urban +
					'}';

	}
	
	/**
	 * This method is sorting the destinations for the
	 * year 2016.
	 */
	@Override
	public int compareTo(Destination d) {
		return this.destinationName.compareTo(d.getDestinationName());
	}
	
	/* Getters and Setters */
	
	public int getDestinationID() {
		return destinationID;
	}

	public void setDestinationID(int destinationID) {
		this.destinationID = destinationID;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
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

