package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;
import items.*;
import utils.DataFormatValidator;

public class DataFileReader {

	public static String DATA_SEPERATOR = ",";
	public static String FILE_NAME_FOLDER = "inputFiles/";
	public static String FILE_NAME_JOURNEYS = FILE_NAME_FOLDER + "journeys.txt";
	public static String FILE_NAME_TAXIS = FILE_NAME_FOLDER + "taxis.txt";
	public static String FILE_NAME_DESTINATIONS_2016 = FILE_NAME_FOLDER + "destinations_2016.txt";
	public static String FILE_NAME_DESTINATIONS_2017 = FILE_NAME_FOLDER + "destinations_2017.txt";

	public DataFileReader() {

		
	}


	/*
	 * 
	 * private void readDestinations2016(){
	 * 
	 * 
	 * try {
	 * 
	 * FileReader fd_destinations_2016 = new
	 * FileReader(FILE_NAME_DESTINATIONS_2016); BufferedReader
	 * destinations_2016_reader = new BufferedReader(fd_destinations_2016);
	 * 
	 * 
	 * int counter = 0;
	 * 
	 * String line; String[] destination_2016_info;
	 * 
	 * try {
	 * 
	 * while ((line = destinations_2016_reader.readLine()) != null) {
	 * 
	 * counter++; destination_2016_info = line.split(DATA_SEPERATOR);
	 * 
	 * if (
	 * !DataFormatValidator.validateDestinationName(destination_2016_info[0]) )
	 * {
	 * 
	 * throw new InvalidDestinationNameException("destinations_2016.txt",
	 * counter); }
	 * 
	 * 
	 * System.out.println(line);
	 * 
	 * }
	 * 
	 * } catch (IOException e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * try {
	 * 
	 * destinations_2016_reader.close();
	 * 
	 * } catch (IOException e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * finally {
	 * 
	 * }
	 * 
	 * 
	 * }
	 */

	public TreeMap<String, ArrayList<Journey>> loadJourney() {

		System.out.println("Nothing");
		return null;
	}

	public TreeMap<String, Taxi> loadTaxis() {

		TreeMap<String, Taxi> some = new TreeMap<String, Taxi>();
		
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

					Taxi tx = new Taxi(taxi_info[0].trim(), taxi_info[1], taxi_info[2].trim());

					if (tx != null) {
						some.put(taxi_info[0], tx);
					}
				}

			} catch (IOException e) {

				e.printStackTrace();
			} finally{
				
				taxis_reader.close();
				
			}
		}

		catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return some;
	}

	public TreeMap<String, Destination> loadDestinations2016() {

		return null;
	}

	public TreeMap<String, Destination> loadDestinations2017() {

		return null;
	}

}
