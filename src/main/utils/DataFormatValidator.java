
package main.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

	public static boolean validateRegistrationNumber(String registrationNumber) {

		if (registrationNumber.length() == Integer.parseInt(TAXI_REGISTRATION_NUMBER_LENGTH))
			return true;
		else
			return false;

	}

	public static boolean validateDriverName(String driverName) {

		if (driverName.length() >= Integer.parseInt(MIN_DRIVER_NAME_LENGTH)
				&& driverName.length() <= Integer.parseInt(MAX_DRIVER_NAME_LENGTH))
			return true;
		else
			return false;
	}

	public static boolean validateBrand(String brandName) {

		if (brandName.length() >= Integer.parseInt(MIN_BRAND_NAME)
				&& brandName.length() <= Integer.parseInt(MAX_BRAND_NAME))
			return true;
		else
			return false;
	}

	public static boolean validateDestinationName(String destinationName) {

		if (destinationName.length() >= Integer.parseInt(MIN_DESTINATION_NAME_LENGTH)
				&& destinationName.length() <= Integer.parseInt(MAX_DESTINATION_NAME_LENGTH))
			return true;
		else
			return false;
	}

	public static boolean validateDistance(double distance) {

		if (distance > MIN_DISTANCE && distance <= MAX_DISTANCE)
			return true;
		else
			return false;
	}

	public static boolean validatePassengerNumber(int passengerNumber) {

		if (passengerNumber >= MIN_NUMBER_OF_PASSENGERS && passengerNumber <= MAX_NUMBER_OF_PASSENGERS)
			return true;
		else
			return false;
	}

	public static boolean validateTime(double time) {

		if (time > MIN_TIME)
			return true;
		else
			return false;
	}

	public static boolean validateMaximumVelocity(double maxVelocity) {

		if (maxVelocity >= MIN_VELOCITY && maxVelocity <= MAX_VELOCITY)
			return true;
		else
			return false;
	}

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
