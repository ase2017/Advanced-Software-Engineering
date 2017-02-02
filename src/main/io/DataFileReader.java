package main.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

import main.exceptions.*;
import main.items.*;
import main.utils.DataFormatValidator;


public class DataFileReader {

	public static final String DATA_SEPERATOR = ",";
	public static final String FILE_NAME_FOLDER = "inputFiles/";
	public static final String FILE_NAME_JOURNEYS = FILE_NAME_FOLDER + "journeys.txt";
	public static final String FILE_NAME_TAXIS = "taxis.txt";
	public static final String FILE_NAME_DESTINATIONS_2016 = FILE_NAME_FOLDER + "destinations_2016.txt";
	public static final String FILE_NAME_DESTINATIONS_2017 = FILE_NAME_FOLDER + "destinations_2017.txt";
	public static int line_counter = 0;
	
	public TreeMap<String, ArrayList<Journey>> loadJourney() {

		TreeMap<String, ArrayList<Journey>> journeyTreeMap = new TreeMap<String, ArrayList<Journey>>();

		try {

			FileReader fd_journeys = new FileReader(FILE_NAME_JOURNEYS);
			BufferedReader journeys_reader = new BufferedReader(fd_journeys);

			int line_counter = 0;

			String line;
			String[] journey_info;

			try {

				while ((line = journeys_reader.readLine()) != null) {

					line_counter++;
					journey_info = line.split(DATA_SEPERATOR);

					// Journey jn = new Journey (journey_info[0],
					// journey_info[1], journey_info[2], journey_info[3],
					// journey_info[4]);

					// if (jn != null) {
					// journeyTreeMap.put(taxi_info[0], tx);
					// }
				}

			} catch (IOException e) {

				e.printStackTrace();

			} finally {

				journeys_reader.close();

			}
		} catch (Exception e) {

			System.out.println(e.toString());
		}

		return journeyTreeMap;
	}

	public TreeMap<String, Taxi> loadTaxis(){

		TreeMap<String, Taxi> taxiTreeMap = new TreeMap<String, Taxi>();

		try {

			FileReader fd_taxis = new FileReader(FILE_NAME_FOLDER + FILE_NAME_TAXIS);
			BufferedReader taxis_reader = new BufferedReader(fd_taxis);

			String line;
			String[] taxi_info;
			line_counter = 0;

			while ((line = taxis_reader.readLine()) != null) {
				
				line_counter++;
				taxi_info = line.split(DATA_SEPERATOR);
				
				try {
					
					if(taxi_info.length != 3){
						
						throw new InvalidInputArgumentsException(FILE_NAME_TAXIS, line_counter);
					}
					
					if (taxi_info[0].trim().isEmpty() || taxi_info[0].trim().length() == 0 || taxi_info[0] == null) {

						throw new InvalidRegistrationNumberException(FILE_NAME_TAXIS, line_counter);
					}

					if (taxi_info[1].isEmpty() || taxi_info[1].length() == 0 || taxi_info[1] == null) {

						throw new InvalidTaxiNameException(FILE_NAME_TAXIS, line_counter);
					}

					if (taxi_info[2].trim().isEmpty() || taxi_info[2].trim().length() == 0 || taxi_info[2] == null) {

						throw new InvalidBrandNameException(FILE_NAME_TAXIS, line_counter);
					}

					Taxi tx = new Taxi(taxi_info[0].trim(), taxi_info[1], taxi_info[2].trim());

					if (tx != null) {
						taxiTreeMap.put(taxi_info[0], tx);
						System.out.println(line);
					}

				} catch (InvalidRegistrationNumberException | InvalidTaxiNameException | InvalidBrandNameException 
						| InvalidInputArgumentsException e) {

					System.out.println(e.getMessage());

				} catch (ArrayIndexOutOfBoundsException e){
					//Something else
				}

			}

		} catch (IOException e) {

			 System.out.println(e.getMessage());
		}

		return taxiTreeMap;
	}

	public TreeMap<String, Destination> loadDestinations2016() {

		TreeMap<String, Destination> destination2016_TreeMap = new TreeMap<String, Destination>();

		try {

			FileReader fd_destinations2016 = new FileReader(FILE_NAME_DESTINATIONS_2016);
			BufferedReader destinations2016_reader = new BufferedReader(fd_destinations2016);

			int line_counter = 0;

			String line;
			String[] destination_2016_info;

			try {

				while ((line = destinations2016_reader.readLine()) != null) {

					line_counter++;
					destination_2016_info = line.split(DATA_SEPERATOR);

					Destination ds = new Destination(destination_2016_info[0]);

					if (ds != null) {

						destination2016_TreeMap.put(destination_2016_info[0], ds);

					}
				}

			} catch (IOException e) {

				e.printStackTrace();

			} finally {

				destinations2016_reader.close();

			}
		} catch (Exception e) {

			System.out.println(e.toString());
		}

		return destination2016_TreeMap;

	}

	public TreeMap<String, Destination> loadDestinations2017() {

		return null;
	}

}