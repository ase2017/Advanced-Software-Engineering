package main.items;

import main.exceptions.InvalidDestinationNameException;
import main.exceptions.InvalidDistanceException;
import main.io.DataFileReader;
import main.utils.DataFormatValidator;

public class Destination implements Comparable<Destination>{

	private int destinationID;
	private String destinationName;
	private double distance;
	private boolean urban;

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
			
			System.out.println(e.getMessage());
			
		}	
		
		/* End of checks */
	}


	public Destination(String destinationName){
		
		this.destinationName = destinationName;
		
		try{
			if ( !DataFormatValidator.validateDriverName(destinationName) ) 
				throw new InvalidDestinationNameException(DataFileReader.FILE_NAME_DESTINATIONS_2016, 0);
		}
		catch(InvalidDestinationNameException e){
			System.out.println(e.getMessage());
		}
		
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

	@Override
	public int compareTo(Destination d) {
		//return String.compare(this.getDestinationName(),d.getDestinationName());
		return this.destinationName.compareTo(d.getDestinationName());
	}
}

