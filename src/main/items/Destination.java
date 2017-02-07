package main.items;

import main.exceptions.InvalidDestinationNameException;
import main.exceptions.InvalidDistanceException;
import main.exceptions.InvalidIDException;
import main.io.DataFileReader;
import main.utils.DataFormatValidator;

public class Destination {

	private Integer destinationID;
	private String destinationName;
	private double distance;
	private boolean urban;

	public Destination(Integer destinationID, String destinationName, double distance, boolean urban){

		this.destinationID = destinationID;
		this.destinationName = destinationName;
		this.distance = distance;
		this.urban = urban;

		/* Checks */

		try{

			if ( !DataFormatValidator.validateDestinationName(destinationName) )
				throw new InvalidDestinationNameException(DataFileReader.FILE_NAME_DESTINATIONS_2017, DataFileReader.line_counter);

			if ( !DataFormatValidator.validateDistance(distance) )
				throw new InvalidDistanceException(DataFileReader.FILE_NAME_DESTINATIONS_2017, DataFileReader.line_counter);

			if ( !DataFormatValidator.validateDestinationID(destinationID))
				throw new InvalidIDException(DataFileReader.FILE_NAME_JOURNEYS, DataFileReader.line_counter);

		} catch(InvalidDestinationNameException | InvalidDistanceException | InvalidIDException  e){

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

	public Integer getDestinationID() {
		return destinationID;
	}

	public void setDestinationID(Integer destinationID) {
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
