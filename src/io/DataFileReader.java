package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

import exceptions.InvalidBrandNameException;
import exceptions.InvalidDestinationNameException;
import exceptions.InvalidRegistrationNumberException;
import exceptions.InvalidTaxiNameException;
import items.*;
import utils.DataFormatValidator;



public class DataFileReader {
	
	public static String DATA_SEPERATOR = ",";
	public static String FILE_NAME_JOURNEYS = "";
	public static String FILE_NAME_TAXIS = "inputFiles/taxis.txt";
	public static String FILE_NAME_DESTINATIONS_2016 = "inputFiles/destinations_2016.txt";
	public static String FILE_NAME_DESTINATIONS_2017 = "";
	
	
	public DataFileReader ()  {
		
		
		try {
			
				readTaxi();
			
		} catch ( FileNotFoundException | InvalidRegistrationNumberException | InvalidTaxiNameException | InvalidBrandNameException e ) {
			
				e.printStackTrace();
		}
		
		try {
			
			 	readDestinations2016();
		
		} catch ( FileNotFoundException | InvalidDestinationNameException e ) {
			
				e.printStackTrace();
		}
		
		
		
	}
	
	
	private void readTaxi() throws FileNotFoundException, InvalidRegistrationNumberException, InvalidTaxiNameException, InvalidBrandNameException {
		
		
		try {
			
				FileReader fd_taxis = new FileReader(FILE_NAME_TAXIS);
				BufferedReader taxis_reader = new BufferedReader(fd_taxis);
				
				
				int counter = 0;
				
			    String line;
			    String[] taxi_info; 
			    
			    try {
			    	
						while ((line = taxis_reader.readLine()) != null) {
							
								counter++;					
								taxi_info = line.split(DATA_SEPERATOR);
								
								if ( !DataFormatValidator.validateRegistrationNumber(taxi_info[0].trim()) ) {
									
										throw new InvalidRegistrationNumberException("taxis.txt", counter);
								}
								
								if ( !DataFormatValidator.validateDriverName( taxi_info[1] )) {
									
										throw new InvalidTaxiNameException("taxis.txt", counter);
									
								}
								if ( !DataFormatValidator.validateBrand( taxi_info[2].trim() )) {
									
										throw new InvalidBrandNameException("taxis.txt", counter);
								}
								
								System.out.println(line);
								
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
	
	
	private void readDestinations2016() throws  FileNotFoundException, InvalidDestinationNameException {
		
		
		try {
			
				FileReader fd_destinations_2016 = new FileReader(FILE_NAME_DESTINATIONS_2016);
				BufferedReader destinations_2016_reader = new BufferedReader(fd_destinations_2016);
				
				
				int counter = 0;
				
			    String line;
			    String[] destination_2016_info; 
			    
			    try {
			    	
						while ((line = destinations_2016_reader.readLine()) != null) {
							
								counter++;					
								destination_2016_info = line.split(DATA_SEPERATOR);
								
								if ( !DataFormatValidator.validateDestinationName(destination_2016_info[0]) ) {
									
										throw new InvalidDestinationNameException("destinations_2016.txt", counter);
								}

								
								System.out.println(line);
								
						}
					
				} catch (IOException e) {
					
						e.printStackTrace();
				}
			    
			    
			    
			    try {
			    	
			    		destinations_2016_reader.close();
			    		
				} catch (IOException e) {
					
						e.printStackTrace();
				}
		    
		}
		
		finally {
			
		}
		

	}
	
	
	public TreeMap<String, ArrayList<Journey>> loadJourney(){
		
		
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
