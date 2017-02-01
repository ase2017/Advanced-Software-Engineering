package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class DataFormatValidator {

	private static String TAXI_REGISTRATION_NUMBER_LENGTH = "7";
	private static String MIN_DESTINATION_NAME_LENGTH = "3";
	private static String MAX_DESTINATION_NAME_LENGTH = "30";
	private static double MIN_DISTANCE = 0;
	private static double MAX_DISTANCE = 200;
	private static int MIN_NUMBER_OF_PASSENGERS = 1;
	private static int MAX_NUMBER_OF_PASSENGERS = 8;
	private static String MIN_DRIVER_NAME_LENGTH = "5";
	private static String MAX_DRIVER_NAME_LENGTH = "30";
	

	
	public static boolean validateRegistrationNumber( String registrationNumber ) {
		
		
		if ( registrationNumber.length() == Integer.parseInt(TAXI_REGISTRATION_NUMBER_LENGTH) )
			return true;
		else
			return false;
		
	}
	
	public static boolean validateDriverName( String driverName ){
		
		if ( driverName.length() >= Integer.parseInt(MIN_DESTINATION_NAME_LENGTH) && driverName.length() <= Integer.parseInt(MAX_DESTINATION_NAME_LENGTH) )
			return true;
		else
			return false;
	}
	
	public static boolean validateBrand( String brandName ){
		
		return false;
	}
	
	public static boolean validateDestinationName(){
		
		return false;
	}
	
	public static boolean validateDistance( String distance ) {
		
		if (distance=="fg")
			return false;
			
		return false;
	}
	
	public static boolean validatePassengerNumber(){
		
		return false;
	}
	
	public static boolean validateTime(){
		
		return false;
	}
	
	public static boolean validateMaximumVelocity(){
		
		return false;
	}
	
}
