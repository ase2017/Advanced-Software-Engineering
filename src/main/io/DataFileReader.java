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
 * DataFileReader is a public class that reads the data from four files
 * <taxis.txt>, <journeys.txt>, <destinations_2016.txt> and <destinations_2017.txt>,
 * then checks if the file is in the wright format, checks if those values exist (not empty),
 * make some converts and finally store them to the appropriate data structure.
 *
 * @author Chiotis
 */
public class DataFileReader {

	public static final String DATA_SEPARATOR = ",";
	public static final String FILE_NAME_FOLDER = "inputFiles/";
	public static final String FILE_NAME_JOURNEYS = "journeys.txt";
	public static final String FILE_NAME_TAXIS = "taxis.txt";
	public static final String FILE_NAME_DESTINATIONS_2016 = "destinations_2016.txt";
	public static final String FILE_NAME_DESTINATIONS_2017 = "destinations_2017.txt";
	public static int line_counter = 0;



	/**
	 *
	 * @return a TreeMap of ArrayLists of Journeys.
	 */
	public JourneyTreeMap loadJourney() {

		return journeyChecker( FILE_NAME_FOLDER, FILE_NAME_JOURNEYS );
	}


	/**
	 *
	 * @return a TreeMap of Taxis.
	 */
	public TaxiTreeMap loadTaxis() {

		return taxiChecker( FILE_NAME_FOLDER, FILE_NAME_TAXIS );
	}


	/**
	 *
	 * @return a TreeSet of last year's destinations.
	 */
	public DestinationTreeSet loadDestinations2016() {

		return destination2016Checker( FILE_NAME_FOLDER, FILE_NAME_DESTINATIONS_2016 );

	}


	/**
	 *
	 * @return a TreeMap of current year destinations.
	 */
	public DestinationTreeMap loadDestinations2017() {

		return destination2017Checker( FILE_NAME_FOLDER, FILE_NAME_DESTINATIONS_2017 );
	}



	/**
	 * journeyChecker reads the file that is specified by the two arguments (default case:
	 * <journey.txt> in inputFiles directory).
	 * Checks its structure as to the number of words separated by DATA_SEPARATOR (instance variable),
	 * also checks if those words are not empty, converts strings to double or integers when needed,
	 * and finally uses Journey's constructor for each valid line and add this journey object to a TreeMap.
	 *
	 * @param directory: locate the directory's path for the input file.
	 * @param filename: the filename of journey's data.
	 *
	 * @exception InvalidInputArgumentsException If the number of arguments in record is not correct
	 * @exception InvalidIDException If the journey's ID is null, empty or zero
	 * @exception InvalidMaximumVelocityException If the maximum velocity is null, empty or zero
	 * @exception InvalidRegistrationNumberException If the registration number is null, empty or zero
	 * @exception InvalidTimeException If the journey's time is null, empty or zero
	 * @exception InvalidNumberOfPassengersException If the number of passengers is null, empty or zero
	 * @exception NumberFormatException If instead of an integer we get a string
	 * @exception ArrayIndexOutOfBoundsException If the reading process fails
	 * @exception IOException If there is not input file
	 * @exception NullPointerException If cannot read the file
	 *
	 * @return an object of JourneyTreeMap, which is a TreeMap of all journeys.
	 */

	public JourneyTreeMap journeyChecker( String directory, String filename ) {

		TreeMap<String, ArrayList<Journey>> temporaryTreeMap = new TreeMap<>();
		JourneyTreeMap journeyTreeMap = new JourneyTreeMap(temporaryTreeMap);


		FileReader fd_journeys = null;

		int id = 0;
		int numOfPassengers = 0;
		double time = 0.0;
		double maxVelocity = 0.0;

		try {

			// Open the file that contains the journeys.
			fd_journeys = new FileReader( directory + filename );
			BufferedReader journey_reader = new BufferedReader(fd_journeys);

			String line = null;
			String[] journey_info = null;
			line_counter = 0;		// Initializes the line counter.

			// Read it line-by-line
			while ((line = journey_reader.readLine()) != null) {

				line_counter++;		// specify the line of the file
				journey_info = line.split(DATA_SEPARATOR, -1);		// split the line using the given separator

				try {

					if (journey_info.length != 5) {        // check if this line has exactly five words
						// if not throw an exception

						throw new InvalidInputArgumentsException(filename, line_counter);
					}

					// Then check if any of those five words are an empty string
					// and if this happens  for any of those strings, throw the appropriate exception

					if (journey_info[0] == null || journey_info[0].trim().isEmpty()) {

						throw new InvalidIDException(filename, line_counter);
					}

					id = Integer.parseInt(journey_info[0]);        // Converts Journey's id to integer.


					if (journey_info[1] == null || journey_info[1].trim().isEmpty()) {

						throw new InvalidRegistrationNumberException(filename, line_counter);
					}


					if (journey_info[2] == null || journey_info[2].trim().isEmpty()) {

						throw new InvalidNumberOfPassengersException(filename, line_counter);
					}

					numOfPassengers = Integer.parseInt(journey_info[2]);        // Converts Number of Passenger of this journey to integer.


					if (journey_info[3] == null || journey_info[3].trim().isEmpty()) {

						throw new InvalidTimeException(filename, line_counter);
					}

					time = Double.parseDouble(journey_info[3]);        // Converts the time needed for this journey to double.


					if (journey_info[4] == null || journey_info[4].trim().isEmpty()) {

						throw new InvalidMaximumVelocityException(filename, line_counter);
					}

					maxVelocity = Double.parseDouble(journey_info[4]);        // Converts maximum velocity of this journey to double.


					// Creates a Journey Object
					Journey jrn = new Journey(id, journey_info[1], numOfPassengers, time, maxVelocity);


					if (jrn != null) {    // if the object has been created normally


						journeyTreeMap.addJourney(jrn);        // add this Journey to the JourneyTreeMap
						// -- which is a TreeMap of ArrayLists of Journey's objects --
						// using the addJourney public method of the
						// JourneyTreeMap class.
					}

				} catch (InvalidInputArgumentsException | InvalidIDException | InvalidMaximumVelocityException
						| InvalidRegistrationNumberException | InvalidTimeException | InvalidNumberOfPassengersException e){

					System.out.println(e.getMessage());

				} catch ( NumberFormatException e ) {

					System.out.println("\t --Number Format exception in file: " + filename + " [ " + e.getMessage() + " ]." );

				} catch ( ArrayIndexOutOfBoundsException e ) {

					System.out.println("\t --Reading process in file " + filename + " failed... [ " + e.getMessage() + " ]." );

				}

			}

		} catch ( IOException |  NullPointerException e ) {

			System.out.println("\t --File: " + filename + " failed to open. [ " + e.getMessage() + " ].");
		}
		finally {

			try {
				if(fd_journeys != null)
					fd_journeys.close();	// Close the file reader.

			} catch (IOException e) {

				System.out.println( "\t --File: " + filename + " failed to close. [ " + e.getMessage() + " ]." );

			}
		}



		return journeyTreeMap;
	}



	/**
	 * taxiChecker reads the file that is specified by the two arguments (default case:
	 * <taxi.txt> in inputFiles directory).
	 * Checks its structure as to the number of words separated by DATA_SEPARATOR (instance variable),
	 * also checks if those words are not empty, converts strings to double or integers when needed,
	 * and finally uses Taxi's constructor for each valid line and add this Taxi object to a TreeMap.
	 *
	 * @param directory: locate the directory's path for the input file.
	 * @param filename: the filename of journey's data.
	 *
	 * @exception InvalidRegistrationNumberException If the registration number is null, empty or zero
	 * @exception InvalidTaxiNameException If the driver's name is null, empty or zero
	 * @exception InvalidBrandNameException If the brand name is null, empty or zero
	 * @exception InvalidInputArgumentsException If the number of arguments is not correct
	 * @exception ArrayIndexOutOfBoundsException If the reading process fails
	 * @exception IOException If the file does not exist
	 * @exception NullPointerException If cannot read file
	 *
	 * @return an object of taxiTreeMap, which is a TreeMap of all taxis.
	 */
	public TaxiTreeMap taxiChecker( String directory, String filename) {

		TreeMap<String,Taxi> temporaryTreeMap = new TreeMap<>();
		TaxiTreeMap taxiTreeMap = new TaxiTreeMap(temporaryTreeMap);

		FileReader fd_taxis = null;

		try {

			// Open the file that contains the taxis.
			fd_taxis = new FileReader(directory + filename);
			BufferedReader taxis_reader = new BufferedReader(fd_taxis);

			String line = null;
			String[] taxi_info = null;
			String [] nameComponents = null;
			line_counter = 0;		// Initializes the line counter.

			// Read it line-by-line
			while ((line = taxis_reader.readLine()) != null) {

				line_counter++;		// specify the line of the file
				taxi_info = line.split(DATA_SEPARATOR, -1);		// split the line using the given separator.

				try {

					nameComponents = taxi_info[1].split(" ");		// slit the driver's name (first name, last name).

					if(taxi_info.length != 3){		// check if this line has exactly three words
						// if not throw an exception

						throw new InvalidInputArgumentsException(filename, line_counter);
					}

					// Then check if any of those three words are an empty string
					// and if this happens for any of those strings, throw the appropriate exception

					if (taxi_info[0] == null || taxi_info[0].trim().isEmpty()) {

						throw new InvalidRegistrationNumberException(filename, line_counter);
					}

					if (taxi_info[1] == null || taxi_info[1].trim().isEmpty()
							|| nameComponents[0].length() == 0 || nameComponents[1].length() == 0 ) {

						throw new InvalidTaxiNameException(filename, line_counter);
					}

					if (taxi_info[2] == null || taxi_info[2].trim().isEmpty()) {

						throw new InvalidBrandNameException(filename, line_counter);
					}


					// Creates a Taxi Object
					Taxi tx = new Taxi(taxi_info[0].trim(), taxi_info[1], taxi_info[2].trim());


					if ( tx != null ) {		// if the object has been created normally

						taxiTreeMap.addTaxi(tx);	// add this Taxi to the TaxiTreeMap
						// -- which is a TreeMap of Taxi's objects --
						// using the addTaxi public method of the
						// TaxiTreeMap class.

					}


				} catch ( InvalidRegistrationNumberException | InvalidTaxiNameException | InvalidBrandNameException
						| InvalidInputArgumentsException e) {

					System.out.println(e.getMessage());

				} catch (ArrayIndexOutOfBoundsException e){

					System.out.println("\t --Reading process in file " + filename + " failed... [ " + line_counter + " ]." );

				}
			}

		} catch ( IOException |  NullPointerException e ) {

			System.out.println("\t --File: " + filename + " failed to open. [ " + e.getMessage() + " ].");

		}
		finally {

			try {

				if(fd_taxis != null)
					fd_taxis.close();		// Close the file descriptor.

			} catch ( IOException e ) {

				System.out.println("\t --File: " + filename + " failed to close. [ " + e.getMessage() + " ].");

			}
		}

		return taxiTreeMap;
	}


	/**
	 * destination2016Checker reads the file that is specified by the two arguments (default case:
	 * <destinations_2016.txt> in inputFiles directory).
	 *
	 * Checks its structure as to the number of words separated by DATA_SEPARATOR (instance variable),
	 * then checks if those words are not empty,  and for each valid line add this Destination object to a DestinationTreeSet.
	 *
	 * @param directory: locate the directory's path for the input file.
	 * @param filename: the filename of journey's data.
	 *
	 * @exception InvalidDestinationNameException If the destination's name is null, empty or zero
	 * @exception InvalidInputArgumentsException If the number of arguments in record is not correct
	 * @exception ArrayIndexOutOfBoundsException If the reading process fails
	 * @exception IOException If the file does not exist
	 * @exception NullPointerException If cannot read file
	 *
	 * @return an object of DestinationTreeSet, which is a TreeSet of all the destinations visited by the taxis in 2016.
	 */
	public DestinationTreeSet destination2016Checker( String directory, String filename ) {

		TreeSet<Destination> temporaryTreeSet = new TreeSet<Destination>();
		DestinationTreeSet destinations2016 = new DestinationTreeSet(temporaryTreeSet);


		FileReader fd_destination_2016 = null;

		try {

			// Open the file that contains the last's year destinations.
			fd_destination_2016 = new FileReader( directory + filename );
			BufferedReader destination_2016_reader = new BufferedReader(fd_destination_2016);

			String line = null;
			line_counter = 0;		// Initializes the line counter

			// Read it line-by-line
			while ((line = destination_2016_reader.readLine()) != null) {

				line_counter++;		// Specifies the number of the current line.

				try {

					if( line == null || line.trim().isEmpty() ) {

						throw new InvalidDestinationNameException(filename, line_counter);
					}

					// Create the Destination Object using the appropriate constructor.
					Destination dest2016 = new Destination( line );


					if ( dest2016 != null ) { 	// if the object has been created normally

						temporaryTreeSet.add(dest2016);		// add this Destination to the DestinationTreeSet
						// -- which is a TreeSet of Destination's objects --
						// using the add method of the TreeSet data structure.

					}

				} catch ( InvalidDestinationNameException e ) {

					System.out.println(e.getMessage());
				}


			}

		} catch ( IOException |  NullPointerException e ) {

			System.out.println("\t --File: " + filename + " failed to open. [ " + e.getMessage() + " ].");
		}
		finally {

			try {
				if(fd_destination_2016 != null)
					fd_destination_2016.close();	// Close the file descriptor.

			} catch (IOException e) {

				System.out.println("\t --File: " + filename + " failed to close. [ " + e.getMessage() + " ].");

			}
		}


		return destinations2016;
	}



	/**
	 * destination2017Checker reads the file that is specified by the two arguments (default case:
	 * <destinations_2017.txt> in inputFiles directory).
	 *
	 * Checks its structure as to the number of words separated by DATA_SEPARATOR (instance variable),
	 * then checks if those words are not empty, converts strings to double or integers when needed,
	 * and for each valid line add this Destination object to a DestinationTreeMap.
	 *
	 * @param directory: locate the directory's path for the input file.
	 * @param filename: the filename of journey's data.
	 *
	 * @exception DuplicateIDException If a destination with the same ID already exists
	 * @exception InvalidIDException If a destination with null, empty or zero ID exists
	 * @exception InvalidInputArgumentsException If the arguments of a record are null, empty or zero
	 * @exception InvalidDestinationNameException If the destination's name is null, empty or zero
	 * @exception InvalidDistanceException If the destination's distance is null, empty or zero
	 * @exception InvalidUrbanException If the urban identifier is null, empty or zero
	 * @exception NumberFormatException If instead of a number we get a string
	 * @exception ArrayIndexOutOfBoundsException If the reading process fails
	 * @exception IOException If the input file does not exist
	 * @exception NullPointerException If cannot open the file
	 *
	 * @return an object of DestinationTreeMap, which is a TreeMap of all the destinations visited by the taxis in 2017.
	 */
	public DestinationTreeMap destination2017Checker( String directory, String filename ) {

		TreeMap<Integer,Destination> temporaryTreeMap = new TreeMap<>();
		DestinationTreeMap destination2017_TreeMap = new DestinationTreeMap(temporaryTreeMap);


		FileReader fd_destination_2017 = null;

		int id = 0;
		double distance = 0.0;
		boolean urban = false;

		try {

			// Open the file that contains the current's year destinations.
			fd_destination_2017 = new FileReader( directory + filename );
			BufferedReader destination_2017_reader = new BufferedReader(fd_destination_2017);

			String line = null;
			String[] destination_2017_info = null;
			line_counter = 0;		// Initializes the line counter.

			// Read it line-by-line
			while ((line = destination_2017_reader.readLine()) != null) {

				line_counter++;		// Specify the current number of the line.
				destination_2017_info = line.split(DATA_SEPARATOR, -1);		// Split its words as to the given separator.

				try {

					if( destination_2017_info.length != 4 ) {	// check if this line has exactly four words
						// if not throw an exception.

						throw new InvalidInputArgumentsException( filename, line_counter );
					}

					if ( destination_2017_info[0] == null  || destination_2017_info[0].trim().isEmpty()) {

						throw new InvalidIDException( filename, line_counter );
					}


					id = Integer.parseInt( destination_2017_info[0] );		// Converts the destination's ID to integer.


					if (destination_2017_info[1] == null || destination_2017_info[1].trim().isEmpty()) {

						throw new InvalidDestinationNameException( filename, line_counter );
					}


					if (destination_2017_info[2] == null || destination_2017_info[2].trim().isEmpty()) {

						throw new InvalidDistanceException( filename, line_counter );
					}


					distance = Double.parseDouble(destination_2017_info[2]);	// Converts the distance of its journey to double.


					if (destination_2017_info[3] == null || destination_2017_info[3].trim().isEmpty()) {

						throw new InvalidUrbanException( filename, line_counter );
					}


					if ( destination_2017_info[3].equals("Y") )			// If the Urban Variable is Y(es) return true.
						urban = true;
					else if ( destination_2017_info[3].equals("N")  )	// If the Urban Variable is N(o) return false.
						urban = false;
					else
						throw new InvalidUrbanException( filename, line_counter );	// Else throw an exception.


					// Create the Destination Object using the appropriate constructor.
					Destination dest2017 = new Destination( id, destination_2017_info[1], distance, urban );


					if ( dest2017 != null ) {	// if the object has been created normally

						try {

							destination2017_TreeMap.addDestination2017(dest2017);	// add this Destination to the DestinationTreeMap
							// -- which is a TreeMap of Destination's objects --
							// using the public addDestination2017 method of the
							// DestinationTreeMap's class.


						} catch (DuplicateIDException e) {

							System.out.println(e.getMessage());

						}

					}

				} catch (InvalidIDException | InvalidInputArgumentsException | InvalidDestinationNameException |
						InvalidDistanceException | InvalidUrbanException e ) {

					System.out.println(e.getMessage());

				} catch ( NumberFormatException e ) {

					System.out.println("\t --Not a number exception in file: " + filename +  " [ " + e.getMessage() + " ]." );

				} catch ( ArrayIndexOutOfBoundsException e ){

					System.out.println("\t --Reading process in file" + filename +  " failed... [ " + e.getMessage() + " ]." );

				}

			}

		} catch ( IOException |  NullPointerException e ) {

			System.out.println("\t --File: " + filename + " failed to open. [ " + e.getMessage() + " ].");
		}
		finally {

			try {
				if(fd_destination_2017 != null)
					fd_destination_2017.close();	// Close the file descriptor.

			} catch (IOException e) {

				System.out.println("\t --File: " + filename + " failed to close. [ " + e.getMessage() + " ].");

			}
		}

		return destination2017_TreeMap;
	}
}
