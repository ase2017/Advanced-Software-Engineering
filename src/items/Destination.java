package items;

import exceptions.InvalidDestinationNameException;
import exceptions.InvalidDistanceException;
import io.DataFileReader;
import utils.DataFormatValidator;

public class Destination {

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
				throw new InvalidDestinationNameException(DataFileReader.FILE_NAME_DESTINATIONS_2017, 0);
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
	
}

