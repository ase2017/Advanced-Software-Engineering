package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

import exceptions.InvalidBrandNameException;
import exceptions.InvalidRegistrationNumberException;
import exceptions.InvalidTaxiNameException;
import items.*;
import utils.DataFormatValidator;

public class DataFileReader {
	
	public static char DATA_SEPERATOR = ',';
	public static String FILE_NAME_JOURNEYS = "";
	public static String FILE_NAME_TAXIS = "";
	public static String FILE_NAME_DESTINATIONS_2016 = "";
	public static String FILE_NAME_DESTINATIONS_2017 = "";
	
	
	public DataFileReader () throws FileNotFoundException, InvalidRegistrationNumberException, InvalidTaxiNameException, InvalidBrandNameException {
		
		
		
		
		try {
			
			FileReader fd_taxis = new FileReader("inputFiles/taxis.txt");
			BufferedReader taxis_reader = new BufferedReader(fd_taxis);
			
			
			int counter = 0;
			
		    String line;
		    String[] taxi_info; 
		    
		    try {
		    	
					while ((line = taxis_reader.readLine()) != null) {
						
							counter++;					
							taxi_info = line.split(",");
							
							if ( !DataFormatValidator.validateRegistrationNumber(taxi_info[0].trim()) ) {
								
									throw new InvalidRegistrationNumberException("taxis.txt", counter);
							}
							
							if ( !DataFormatValidator.validateDriverName( taxi_info[1] )) {
								
									throw new InvalidTaxiNameException("taxis.txt", counter);
								
							}
							if ( !DataFormatValidator.validateBrand( taxi_info[2] )) {
								
									throw new InvalidBrandNameException("taxis.txt", counter);
							}
							
					}
				
			} catch (IOException e) {
				
					e.printStackTrace();
			}
		    
		    
		    
		    try {
		    	
		    		taxis_reader.close();
		    		
			} catch (IOException e) {
				
					e.printStackTrace();
			}
		    
		}
		finally {
			
		}
	}
	
	
	public TreeMap<String, ArrayList<Journey>> loadJourney(){
		
		System.out.println("Nothing");
		return null;
	}
	
	public TreeMap<String,Taxi> loadTaxis(){
		
		
		return null;
	}
	
	public TreeMap<String, Destination> loadDestinations2016(){
		
		
		return null;
	}
	

	public TreeMap<String, Destination> loadDestinations2017(){
		
	
		return null;
	}
	
	
}
