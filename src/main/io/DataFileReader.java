package main.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

import main.exceptions.DuplicateIDException;
import main.exceptions.InvalidBrandNameException;
import main.exceptions.InvalidDestinationNameException;
import main.exceptions.InvalidDistanceException;
import main.exceptions.InvalidInputArgumentsException;
import main.exceptions.InvalidMaximumVelocityException;
import main.exceptions.InvalidNumberOfPassengersException;
import main.exceptions.InvalidRegistrationNumberException;
import main.exceptions.InvalidTaxiNameException;
import main.exceptions.InvalidTimeException;
import main.exceptions.InvalidUrbanException;
import main.exceptions.InvalidIDException;
import main.items.*;


/**
 * 
 * @author Chiotis
 * 
 * DataFileReader is a public class that reads the data from four files
 * <taxis.txt>, <journeys.txt>, <destinations_2016.txt> and <destinations_2017.txt>, 
 * then checks if the file is in the wright format, checks if those values exist (not empty),
 * make some converts and finally store them to the appropriate data structure. 
 *
 */
public class DataFileReader {
 
	public static final String DATA_SEPERATOR = ",";
	public static final String FILE_NAME_FOLDER = "inputFiles/";
	public static final String FILE_NAME_JOURNEYS = "journeys.txt";
	public static final String FILE_NAME_TAXIS = "taxis.txt";
	public static final String FILE_NAME_DESTINATIONS_2016 = "destinations_2016.txt";
	public static final String FILE_NAME_DESTINATIONS_2017 = "destinations_2017.txt";
	public static int line_counter = 0;



	/**
	 * loadJourney read the <journey.txt> file, checks its structure as to the number of words 
	 * separated by DATA_SEPERATOR (instance variable), then checks if those words are not empty,
	 * and after some converts use Journey's constructor for each valid line and add this
	 * journey object to a TreeMap. 
	 * 
	 * @return an object of JourneyTreeMap, which is a TreeMap of all journeys.  
	 */
	public JourneyTreeMap loadJourney() {


		TreeMap<String,ArrayList<Journey>> temporaryTreeMap = new TreeMap<>();
		JourneyTreeMap journeyTreeMap = new JourneyTreeMap(temporaryTreeMap);


		FileReader fd_journeys = null;

		int id = 0;
		int numOfPassengers = 0;
		double time = 0.0;
		double maxVelocity = 0.0;

		try {

			// Open the file that contains the journeys. 
			fd_journeys = new FileReader( FILE_NAME_FOLDER + FILE_NAME_JOURNEYS );
			BufferedReader journey_reader = new BufferedReader(fd_journeys);

			String line;
			String[] journey_info;
			line_counter = 0;		// Initializes the line counter. 

			// Read it line-by-line
			while ((line = journey_reader.readLine()) != null) {

				line_counter++;		// specify the line of the file
				journey_info = line.split(DATA_SEPERATOR, -1);		// split the line using the given separator

				try {

					if( journey_info.length != 5 ){		// check if this line has exactly five words
														// if not throw an exception
						
						throw new InvalidInputArgumentsException(FILE_NAME_JOURNEYS, line_counter);
					}

					// Then check if any of those five words are an empty string
					// and if this happens  for any of those strings, throw the appropriate exception
					
					if ( journey_info[0].isEmpty() || journey_info[0].length() == 0 || journey_info[0] == null ) {

						throw new InvalidIDException( FILE_NAME_DESTINATIONS_2017, line_counter );
					}
					
					id = Integer.parseInt( journey_info[0] );		// Converts Journey's id to integer.


					if ( journey_info[1].trim().isEmpty() || journey_info[1].trim().length() == 0 || journey_info[1] == null ) {

						throw new InvalidRegistrationNumberException(FILE_NAME_TAXIS, line_counter);
					}


					if ( journey_info[2].isEmpty() || journey_info[2].length() == 0 || journey_info[2] == null ) {

						throw new InvalidNumberOfPassengersException( FILE_NAME_DESTINATIONS_2017, line_counter );
					}

					numOfPassengers = Integer.parseInt( journey_info[2] );		// Converts Number of Passenger of this journey to integer.



					if ( journey_info[3].trim().isEmpty() || journey_info[3].trim().length() == 0 || journey_info[3].trim() == null ) {

						throw new InvalidTimeException( FILE_NAME_DESTINATIONS_2017, line_counter );
					}

					time = Double.parseDouble(journey_info[3]);		// Converts the time needed for this journey to double.



					if ( journey_info[4].trim().isEmpty() || journey_info[4].trim().length() == 0 || journey_info[4].trim() == null ) {

						throw new InvalidMaximumVelocityException( FILE_NAME_DESTINATIONS_2017, line_counter );
					}

					maxVelocity = Double.parseDouble(journey_info[4]);		// Converts maximum velocity of this journey to double.



					// Creates a Journey Object 
					Journey jrn = new Journey( id, journey_info[1], numOfPassengers, time, maxVelocity );



					if ( jrn != null ) {	// if the object has been created normally

						
						journeyTreeMap.addJourney(jrn);		// add this Journey to the JourneyTreeMap
															// -- which is a TreeMap of ArrayLists of Journey's objects --
															// using the addJourney public method of the
															// JourneyTreeMap class.					
					}


				} catch ( InvalidInputArgumentsException | InvalidIDException | InvalidMaximumVelocityException |
						  InvalidRegistrationNumberException | InvalidTimeException | InvalidNumberOfPassengersException | NumberFormatException e ) {

					System.out.println(e.getMessage());

				} catch (ArrayIndexOutOfBoundsException e){

					System.out.println("\t --Reading process in file " + FILE_NAME_JOURNEYS + " failed... [ " + e.getMessage() + " ]." );

				}

			}

		} catch (IOException e) {

			System.out.println("\t --File: " + FILE_NAME_JOURNEYS + " failed to open. [ " + e.getMessage() + " ].");
		}
		finally {

			try {
					
				fd_journeys.close();	// Close the file reader.

			} catch (IOException e) {

				System.out.println( "\t --File: " + FILE_NAME_JOURNEYS + " failed to close. [ " + e.getMessage() + " ]." );

			}
		}


		return journeyTreeMap;
	}


	/**
	 * loadTaxis read the <taxis.txt> file, checks its structure as to the number of words 
	 * separated by DATA_SEPERATOR (instance variable), then checks if those words are not empty,
	 * and for each valid line add this taxi object to a taxiTreeMap.
	 *  
	 * @return an object of taxiTreeMap, which is a TreeMap of all taxis.  
	 */
	public TaxiTreeMap loadTaxis() {



		TreeMap<String,Taxi> temporaryTreeMap = new TreeMap<>();
		TaxiTreeMap taxiTreeMap = new TaxiTreeMap(temporaryTreeMap);

		FileReader fd_taxis = null;

		try {

			// Open the file that contains the taxis. 
			fd_taxis = new FileReader(FILE_NAME_FOLDER + FILE_NAME_TAXIS);
			BufferedReader taxis_reader = new BufferedReader(fd_taxis);

			String line;
			String[] taxi_info;
			String [] nameComponents;
			line_counter = 0;		// Initializes the line counter. 

			// Read it line-by-line
			while ((line = taxis_reader.readLine()) != null) {

				line_counter++;		// specify the line of the file
				taxi_info = line.split(DATA_SEPERATOR, -1);		// split the line using the given separator.
				nameComponents = taxi_info[1].split(" ");		// slit the driver's name (first name, last name).

				try {

					if(taxi_info.length != 3){		// check if this line has exactly three words
													// if not throw an exception

						throw new InvalidInputArgumentsException(FILE_NAME_TAXIS, line_counter);
					}

					// Then check if any of those three words are an empty string
					// and if this happens for any of those strings, throw the appropriate exception
					
					if (taxi_info[0].trim().isEmpty() || taxi_info[0].trim().length() == 0 || taxi_info[0] == null) {

						throw new InvalidRegistrationNumberException(FILE_NAME_TAXIS, line_counter);
					}

					if (taxi_info[1].isEmpty() || taxi_info[1].length() == 0 || taxi_info[1] == null || nameComponents[0].length() == 0 || nameComponents[1].length() == 0 ) {

						throw new InvalidTaxiNameException(FILE_NAME_TAXIS, line_counter);
					}

					if (taxi_info[2].trim().isEmpty() || taxi_info[2].trim().length() == 0 || taxi_info[2] == null) {

						throw new InvalidBrandNameException(FILE_NAME_TAXIS, line_counter);
					}


					// Creates a Taxi Object 
					Taxi tx = new Taxi(taxi_info[0].trim(), taxi_info[1], taxi_info[2].trim());

					
					if ( tx != null ) {		// if the object has been created normally

						taxiTreeMap.addTaxi(tx);	// add this Taxi to the TaxiTreeMap
													// -- which is a TreeMap of Taxi's objects --
													// using the addTaxi public method of the
													// TaxiTreeMap class.
						
					}


				} catch ( InvalidRegistrationNumberException | InvalidTaxiNameException | InvalidBrandNameException | InvalidInputArgumentsException e ) {

					System.out.println("\t --File: " + FILE_NAME_TAXIS + " failed to open. [ " + e.getMessage() + " ].");

				} catch (ArrayIndexOutOfBoundsException e){

					System.out.println("\t --Reading process in file " + FILE_NAME_TAXIS + " failed... [ " + e.getMessage() + " ]." );

				}

			}

		} catch (IOException e) {

			System.out.println("\t --File: " + FILE_NAME_TAXIS + " failed to open. [ " + e.getMessage() + " ].");

		}
		finally {

			try {

				fd_taxis.close();		// Close the file descriptor. 

			} catch (IOException e) {

				System.out.println("\t --File: " + FILE_NAME_TAXIS + " failed to close. [ " + e.getMessage() + " ].");

			}
		}

		return taxiTreeMap;
	}


	/**
	 * loadDestinations2016 read the <destinations_2016.txt> file, checks its structure as to the number of words 
	 * separated by DATA_SEPERATOR (instance variable), then checks if those words are not empty,
	 * and for each valid line add this Destination object to a DestinationTreeSet.
	 *  
	 * @return an object of DestinationTreeSet, which is a TreeSet of all the destinations visited by the taxis in 2016.  
	 */
	public DestinationTreeSet loadDestinations2016() {

		TreeSet<Destination> temporaryTreeSet = new TreeSet<Destination>();
		DestinationTreeSet destinations2016 = new DestinationTreeSet(temporaryTreeSet);


		FileReader fd_destination_2016 = null;

		try {

			// Open the file that contains the last's year destinations. 
			fd_destination_2016 = new FileReader( FILE_NAME_FOLDER + FILE_NAME_DESTINATIONS_2016 );
			BufferedReader destination_2016_reader = new BufferedReader(fd_destination_2016);

			String line;
			String[] destination_2016_info;
			line_counter = 0;		// Initializes the line counter

			// Read it line-by-line
			while ((line = destination_2016_reader.readLine()) != null) {

				line_counter++;		// Specifies the number of the current line. 
				destination_2016_info = line.split(DATA_SEPERATOR, -1);		// Split the data
																			// (in the case that a SEPARATOR exists at the end of each line).

				try {

					if( destination_2016_info.length != 1 ) { 	// check if this line has exactly one word
																// if not throw an exception.

						throw new InvalidInputArgumentsException(FILE_NAME_DESTINATIONS_2016, line_counter);
					}
					
					if ( destination_2016_info[0].isEmpty() || destination_2016_info[0].length() == 0 || destination_2016_info[0] == null ) {

						throw new InvalidDestinationNameException(FILE_NAME_DESTINATIONS_2016, line_counter);
					}
					
					// Create the Destination Object using the appropriate constructor. 
					Destination dest2016 = new Destination( destination_2016_info[0] );

					
					if ( dest2016 != null ) { 	// if the object has been created normally

						temporaryTreeSet.add(dest2016);		// add this Destination to the DestinationTreeSet
															// -- which is a TreeSet of Destination's objects --
															// using the add method of the TreeSet data structure.
															


					}


				} catch ( InvalidDestinationNameException | InvalidInputArgumentsException e ) {

					System.out.println("Name : " + destination_2016_info[0]);
					System.out.println(e.getMessage());

				} catch (ArrayIndexOutOfBoundsException e){

					System.out.println("\t --Reading process in file " + FILE_NAME_DESTINATIONS_2016 + " failed... [ " + e.getMessage() + " ]." );

				}

			}

		} catch (IOException e) {

			System.out.println("\t --File: " + FILE_NAME_DESTINATIONS_2016 + " failed to open. [ " + e.getMessage() + " ].");
		}
		finally {

			try {

				fd_destination_2016.close();	// Close the file descriptor.

			} catch (IOException e) {

				System.out.println("\t --File: " + FILE_NAME_DESTINATIONS_2016 + " failed to close. [ " + e.getMessage() + " ].");

			}
		}


		return destinations2016;

	}


	/**
	 * loadDestinations2017 read the <destinations_2017.txt> file, checks its structure as to the number of words 
	 * separated by DATA_SEPERATOR (instance variable), then checks if those words are not empty,
	 * and for each valid line, add this Destination object to a DestinationTreeMap.
	 *  
	 * @return an object of DestinationTreeMap, which is a TreeMap of all the destinations visited by the taxis in 2017.  
	 */
	public DestinationtTreeMap loadDestinations2017() {
		
		TreeMap<Integer,Destination> temporaryTreeMap = new TreeMap<>();
		DestinationtTreeMap destination2017_TreeMap = new DestinationtTreeMap(temporaryTreeMap);


		FileReader fd_destination_2017 = null;

		int id = 0;
		double distance = 0.0;
		boolean urban = false;

		try {

			// Open the file that contains the current's year destinations. 
			fd_destination_2017 = new FileReader( FILE_NAME_FOLDER + FILE_NAME_DESTINATIONS_2017 );
			BufferedReader destination_2017_reader = new BufferedReader(fd_destination_2017);

			String line;
			String[] destination_2017_info;
			line_counter = 0;		// Initializes the line counter.

			// Read it line-by-line
			while ((line = destination_2017_reader.readLine()) != null) {

				line_counter++;		// Specify the current number of the line. 
				destination_2017_info = line.split(DATA_SEPERATOR, -1);		// Split its words as to the given separator. 

				try {

					if( destination_2017_info.length != 4 ) {	// check if this line has exactly four words
																// if not throw an exception.

						throw new InvalidInputArgumentsException( FILE_NAME_DESTINATIONS_2017, line_counter );
					}

					if ( destination_2017_info[0].trim().isEmpty() || destination_2017_info[0].trim().length() == 0 || destination_2017_info[0].trim() == null ) {

						throw new InvalidIDException( FILE_NAME_DESTINATIONS_2017, line_counter );
					}


					id = Integer.parseInt( destination_2017_info[0] );		// Converts the destination's ID to integer. 


					if ( destination_2017_info[1].isEmpty() || destination_2017_info[1].length() == 0 || destination_2017_info[1] == null ) {

						throw new InvalidDestinationNameException( FILE_NAME_DESTINATIONS_2017, line_counter );
					}


					if ( destination_2017_info[2].trim().isEmpty() || destination_2017_info[2].trim().length() == 0 || destination_2017_info[2].trim() == null ) {

						throw new InvalidDistanceException( FILE_NAME_DESTINATIONS_2017, line_counter );
					}
					

					distance = Double.parseDouble(destination_2017_info[2]);	// Converts the distance of its journey to double. 


					if ( destination_2017_info[3].trim().isEmpty() || destination_2017_info[3].trim().length() == 0 || destination_2017_info[3].trim() == null ) {

						throw new InvalidUrbanException( FILE_NAME_DESTINATIONS_2017, line_counter );
					}


					if ( destination_2017_info[3].trim().equals("Y") )			// If the Urban Variable is Y(es) return true.
						urban = true;
					else if ( destination_2017_info[3].trim().equals("N")  )	// If the Urban Variable is N(o) return false.
						urban = false;
					else
						throw new InvalidUrbanException( FILE_NAME_DESTINATIONS_2017, line_counter );	// Else throw an exception.


					// Create the Destination Object using the appropriate constructor.
					Destination dest2017 = new Destination( id, destination_2017_info[1], distance, urban );

						
					if ( dest2017 != null ) {	// if the object has been created normally

						try {

							destination2017_TreeMap.addDestination2017(dest2017);	// add this Destination to the DestinationTreeMap
																					// -- which is a TreeMap of Destination's objects --
																					// using the public addDestination2017 method of the 
																					// DestinationTreeMap's class.


						} catch (DuplicateIDException e) {

							System.out.println("\t ==> Dublicate destination found in " + FILE_NAME_DESTINATIONS_2017 + " " + e.getMessage());

						}

					}


				} catch ( InvalidIDException | InvalidInputArgumentsException | InvalidDestinationNameException |
						  InvalidDistanceException | InvalidUrbanException | NumberFormatException e ) {

					System.out.println(e.getMessage());

				} catch ( ArrayIndexOutOfBoundsException e ){

					System.out.println("\t --Reading process in file" + FILE_NAME_DESTINATIONS_2017 +  " failed... [ " + e.getMessage() + " ]." );

				}

			}

		} catch (IOException e) {

			System.out.println("\t --File: " + FILE_NAME_DESTINATIONS_2017 + " failed to open. [ " + e.getMessage() + " ].");
		}
		finally {

			try {

				fd_destination_2017.close();	// Close the file descriptor. 

			} catch (IOException e) {

				System.out.println("\t --File: " + FILE_NAME_DESTINATIONS_2017 + " failed to close. [ " + e.getMessage() + " ].");

			}
		}


		return destination2017_TreeMap;
	}

}