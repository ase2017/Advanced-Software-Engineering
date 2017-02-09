
package main.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * 
 * @author Hector
 * 
 * DataFormatValidator exclusively contains static instance variables and methods so to be accessible 
 * from all the other classes. It validates all the input data from the four data files <taxis.txt>, <journeys.txt>, 
 * <destinations_2016.txt> and <destinations_2017.txt> just before the creation of the objects.  
 *  
 * The instance variables are static and final, so that cannot be mutable from the methods. 
 * 
 * Methods are static, so to be accessible from each of the three constructors, (Taxi, Journey and Destination).
 *
 */
public class DataFormatValidator {


	private static final String TAXI_REGISTRATION_NUMBER_LENGTH = "7";
	private static final String MIN_DESTINATION_NAME_LENGTH = "3";
	private static final String MAX_DESTINATION_NAME_LENGTH = "30";
	private static final String MIN_DRIVER_NAME_LENGTH = "5";
	private static final String MAX_DRIVER_NAME_LENGTH = "30";
	private static final String MIN_BRAND_NAME = "3";
	private static final String MAX_BRAND_NAME = "15";
	private static final int MIN_NUMBER_OF_PASSENGERS = 1;
	private static final int MAX_NUMBER_OF_PASSENGERS = 8;
	private static final double MIN_VELOCITY = 0.0;
	private static final double MAX_VELOCITY = 130.0;
	private static final double MIN_DISTANCE = 0;
	private static final double MAX_DISTANCE = 200;
	private static final double MIN_TIME = 0.0;

	/**
	 * Validates the taxi's registration number, as to its length.
	 * 
	 * @param registrationNumber
	 * @return true if the registration number's length equals the indicated length 
	 *         by the corresponding instance variable. 
	 *         Else return false. 
	 */
	public static boolean validateRegistrationNumber(String registrationNumber) {

		if (registrationNumber.length() == Integer.parseInt(TAXI_REGISTRATION_NUMBER_LENGTH))
			return true;
		else
			return false;

	}

	/**
	 * Validates the driver's name, as to the range of its length. 
	 * 
	 * @param driverName
	 * @return true if the taxi's driver name is in the indicated range 
	 *         by the corresponding instance variables.
	 *         Else return false. 
	 */
	public static boolean validateDriverName(String driverName) {

		if (driverName.length() >= Integer.parseInt(MIN_DRIVER_NAME_LENGTH)
				&& driverName.length() <= Integer.parseInt(MAX_DRIVER_NAME_LENGTH))
			return true;
		else
			return false;
	}

	/**
	 * Validates the taxi's brand name, as to the range of its length. 
	 * 
	 * @param brandName
	 * @return true if the brand name is in the indicated range by the
	 *         corresponding instance variables.
	 *         Else return false. 
	 */
	public static boolean validateBrand(String brandName) {

		if (brandName.length() >= Integer.parseInt(MIN_BRAND_NAME)
				&& brandName.length() <= Integer.parseInt(MAX_BRAND_NAME))
			return true;
		else
			return false;
	}

	/**
	 * Validates the journey's destination name, as to the range of its length. 
	 * 
	 * @param destinationName
	 * @return true if the destination's name is in the indicated range 
	 *              by the corresponding instance variables.
	 *              Else return false. 
	 */
	public static boolean validateDestinationName(String destinationName) {

		if (destinationName.length() >= Integer.parseInt(MIN_DESTINATION_NAME_LENGTH)
				&& destinationName.length() <= Integer.parseInt(MAX_DESTINATION_NAME_LENGTH))
			return true;
		else
			return false;
	}

	/**
	 * Validates the distance covered by the taxi in a journey, as to a specified range. 
	 * 
	 * @param distance
	 * @return true if the distance covered by the taxi is in the indicated range
	 *              by the corresponding instance variables. 
	 *              Else return false. 
	 */
	public static boolean validateDistance(double distance) {

		if (distance > MIN_DISTANCE && distance <= MAX_DISTANCE)
			return true;
		else
			return false;
	}

	/**
	 * Validates the number of the passenger, as to a specified range. 
	 * 
	 * @param passengerNumber
	 * @return true if the number of the passengers are in the indicated range by the
	 *         corresponding instance variables. 
	 */
	public static boolean validatePassengerNumber(int passengerNumber) {

		if (passengerNumber >= MIN_NUMBER_OF_PASSENGERS && passengerNumber <= MAX_NUMBER_OF_PASSENGERS)
			return true;
		else
			return false;
	}

	/**
	 * Validates the time needed a journey, as to its sign.
	 * 
	 * @param time
	 * @return true if time is positive.
	 *         Else return false. 
	 */
	public static boolean validateTime(double time) {

		if (time > MIN_TIME)
			return true;
		else
			return false;
	}

	/**
	 * Validates the taxi's maximum velocity of a journey. 
	 * 
	 * @param maxVelocity
	 * @return true if the maximum velocity is in the indicated range
	 *         by the corresponding instance variables.
	 */
	public static boolean validateMaximumVelocity(double maxVelocity) {

		if (maxVelocity >= MIN_VELOCITY && maxVelocity <= MAX_VELOCITY)
			return true;
		else
			return false;
	}

	/**
	 * Validates whether the destination is in urban area or not.
	 * 
	 * @param urban
	 * @return
	 */
	public static boolean validateUrban(String urban) {

		if (urban == "Y" || urban == "N")
			return true;
		else
			return false;
	}
	
	public static boolean validateDestinationID(int destinationID){
	
		if(destinationID > 0) {
			return true;
		}

		return false;
	}
}
