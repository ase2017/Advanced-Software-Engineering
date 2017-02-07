package main.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

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

public class DataFileReader {

	public static final String DATA_SEPERATOR = ",";
	public static final String FILE_NAME_FOLDER = "inputFiles/";
	public static final String FILE_NAME_JOURNEYS = "journeys.txt";
	public static final String FILE_NAME_TAXIS = "taxis.txt";
	public static final String FILE_NAME_DESTINATIONS_2016 = "destinations_2016.txt";
	public static final String FILE_NAME_DESTINATIONS_2017 = "destinations_2017.txt";
	public static int line_counter = 0;



	public JourneyTreeMap loadJourney() {


		TreeMap<String,ArrayList<Journey>> temporaryTreeMap = new TreeMap<>();
		JourneyTreeMap journeyTreeMap = new JourneyTreeMap(temporaryTreeMap);


		FileReader fd_journeys = null;

		int id = 0;
		int numOfPassengers = 0;
		double time = 0.0;
		double maxVelocity = 0.0;

		try {

			fd_journeys = new FileReader( FILE_NAME_FOLDER + FILE_NAME_JOURNEYS );
			BufferedReader journey_reader = new BufferedReader(fd_journeys);

			String line;
			String[] journey_info;
			line_counter = 0;

			while ((line = journey_reader.readLine()) != null) {

				line_counter++;
				journey_info = line.split(DATA_SEPERATOR, -1);

				try {

					if( journey_info.length != 5 ){

						throw new InvalidInputArgumentsException(FILE_NAME_JOURNEYS, line_counter);
					}

					if ( journey_info[0].isEmpty() || journey_info[0].length() == 0 || journey_info[0] == null ) {

						throw new InvalidIDException( FILE_NAME_DESTINATIONS_2017, line_counter );
					}

					id = Integer.parseInt( journey_info[0] );


					if ( journey_info[1].trim().isEmpty() || journey_info[1].trim().length() == 0 || journey_info[1] == null ) {

						throw new InvalidRegistrationNumberException(FILE_NAME_TAXIS, line_counter);
					}


					if ( journey_info[2].isEmpty() || journey_info[2].length() == 0 || journey_info[2] == null ) {

						throw new InvalidNumberOfPassengersException( FILE_NAME_DESTINATIONS_2017, line_counter );
					}

					numOfPassengers = Integer.parseInt( journey_info[2] );



					if ( journey_info[3].trim().isEmpty() || journey_info[3].trim().length() == 0 || journey_info[3].trim() == null ) {

						throw new InvalidTimeException( FILE_NAME_DESTINATIONS_2017, line_counter );
					}

					time = Double.parseDouble(journey_info[3]);



					if ( journey_info[4].trim().isEmpty() || journey_info[4].trim().length() == 0 || journey_info[4].trim() == null ) {

						throw new InvalidMaximumVelocityException( FILE_NAME_DESTINATIONS_2017, line_counter );
					}

					maxVelocity = Double.parseDouble(journey_info[4]);




					Journey jrn = new Journey( id, journey_info[1], numOfPassengers, time, maxVelocity );



					if ( jrn != null ) {

						
						journeyTreeMap.addJourney(jrn);
						
					}


				} catch ( InvalidInputArgumentsException | InvalidIDException | InvalidMaximumVelocityException |
						InvalidRegistrationNumberException | InvalidTimeException | InvalidNumberOfPassengersException | NumberFormatException e ) {

					System.out.println(e.getMessage());

				} catch (ArrayIndexOutOfBoundsException e){

					System.out.println("*** Reading process failed ( Index out of bounds: " + e.getMessage() + " )." );

				}

			}

		} catch (IOException e) {

			System.out.println(e.getMessage());
		}
		finally {

			try {

				fd_journeys.close();

			} catch (IOException e) {

				e.getMessage();

			}
		}


		return journeyTreeMap;
	}


	public TaxiTreeMap loadTaxis(){



		TreeMap<String,Taxi> temporaryTreeMap = new TreeMap<>();
		TaxiTreeMap taxiTreeMap = new TaxiTreeMap(temporaryTreeMap);

		FileReader fd_taxis = null;

		try {

			fd_taxis = new FileReader(FILE_NAME_FOLDER + FILE_NAME_TAXIS);
			BufferedReader taxis_reader = new BufferedReader(fd_taxis);

			String line;
			String[] taxi_info;
			String [] nameComponents;
			line_counter = 0;

			while ((line = taxis_reader.readLine()) != null) {

				line_counter++;
				taxi_info = line.split(DATA_SEPERATOR, -1);
				nameComponents = taxi_info[1].split(" ");

				try {

					if(taxi_info.length != 3){

						throw new InvalidInputArgumentsException(FILE_NAME_TAXIS, line_counter);
					}

					if (taxi_info[0].trim().isEmpty() || taxi_info[0].trim().length() == 0 || taxi_info[0] == null) {

						throw new InvalidRegistrationNumberException(FILE_NAME_TAXIS, line_counter);
					}

					if (taxi_info[1].isEmpty() || taxi_info[1].length() == 0 || taxi_info[1] == null || nameComponents[0].length() == 0 || nameComponents[1].length() == 0 ) {

						throw new InvalidTaxiNameException(FILE_NAME_TAXIS, line_counter);
					}

					if (taxi_info[2].trim().isEmpty() || taxi_info[2].trim().length() == 0 || taxi_info[2] == null) {

						throw new InvalidBrandNameException(FILE_NAME_TAXIS, line_counter);
					}



					Taxi tx = new Taxi(taxi_info[0].trim(), taxi_info[1], taxi_info[2].trim());

					if ( tx != null ) {

						taxiTreeMap.addTaxi(tx);
						
					}


				} catch ( InvalidRegistrationNumberException | InvalidTaxiNameException | InvalidBrandNameException | InvalidInputArgumentsException e ) {

					System.out.println(e.getMessage());

				} catch (ArrayIndexOutOfBoundsException e){

					System.out.println("*** Reading process failed ( Index out of bounds: " + e.getMessage() + " )." );

				}

			}

		} catch (IOException e) {

			System.out.println(e.getMessage());

		}
		finally {

			try {

				fd_taxis.close();

			} catch (IOException e) {

				e.getMessage();

			}
		}

		return taxiTreeMap;
	}


	public DestinationtTreeMap loadDestinations2016() {

		
		TreeMap<Integer,Destination> temporaryTreeMap = new TreeMap<>();
		DestinationtTreeMap destination2016_TreeMap = new DestinationtTreeMap(temporaryTreeMap);

		FileReader fd_destination_2016 = null;

		try {

			fd_destination_2016 = new FileReader( FILE_NAME_FOLDER + FILE_NAME_DESTINATIONS_2016 );
			BufferedReader destination_2016_reader = new BufferedReader(fd_destination_2016);

			String line;
			String[] destination_2016_info;
			line_counter = 0;

			while ((line = destination_2016_reader.readLine()) != null) {

				line_counter++;
				destination_2016_info = line.split(DATA_SEPERATOR, -1);

				try {

					if( destination_2016_info.length != 1 ){

						throw new InvalidInputArgumentsException(FILE_NAME_DESTINATIONS_2016, line_counter);
					}

					if ( destination_2016_info[0].isEmpty() || destination_2016_info[0].length() == 0 || destination_2016_info[0] == null ) {

						throw new InvalidDestinationNameException(FILE_NAME_DESTINATIONS_2016, line_counter);
					}



					Destination dest2016 = new Destination( destination_2016_info[0] );


					if ( dest2016 != null ) {

						//try {

							destination2016_TreeMap.addDestination(dest2016);
							temporaryTreeMap.put(dest2016.getDestinationID(),dest2016);

						/*} catch (DuplicateIDException e) {

							System.out.println(e.getMessage());
						};*/

					}


				} catch ( InvalidDestinationNameException | InvalidInputArgumentsException e ) {

					System.out.println(e.getMessage());

				} catch (ArrayIndexOutOfBoundsException e){

					System.out.println("*** Reading process failed ( Index out of bounds: " + e.getMessage() + " )." );

				}

			}

		} catch (IOException e) {

			System.out.println(e.getMessage());
		}
		finally {

			try {

				fd_destination_2016.close();

			} catch (IOException e) {

				e.getMessage();

			}
		}


		return destination2016_TreeMap;

	}


	public DestinationtTreeMap loadDestinations2017() {

		
		TreeMap<Integer,Destination> temporaryTreeMap = new TreeMap<>();
		DestinationtTreeMap destination2017_TreeMap = new DestinationtTreeMap(temporaryTreeMap);


		FileReader fd_destination_2017 = null;

		int id = 0;
		double distance = 0.0;
		boolean urban = false;

		try {

			fd_destination_2017 = new FileReader( FILE_NAME_FOLDER + FILE_NAME_DESTINATIONS_2017 );
			BufferedReader destination_2017_reader = new BufferedReader(fd_destination_2017);

			String line;
			String[] destination_2017_info;
			line_counter = 0;

			while ((line = destination_2017_reader.readLine()) != null) {

				line_counter++;
				destination_2017_info = line.split(DATA_SEPERATOR, -1);

				try {

					if( destination_2017_info.length != 4 ){

						throw new InvalidInputArgumentsException( FILE_NAME_DESTINATIONS_2017, line_counter );
					}

					if ( destination_2017_info[0].trim().isEmpty() || destination_2017_info[0].trim().length() == 0 || destination_2017_info[0].trim() == null ) {

						throw new InvalidIDException( FILE_NAME_DESTINATIONS_2017, line_counter );
					}


					id = Integer.parseInt( destination_2017_info[0] );


					if ( destination_2017_info[1].isEmpty() || destination_2017_info[1].length() == 0 || destination_2017_info[1] == null ) {

						throw new InvalidDestinationNameException( FILE_NAME_DESTINATIONS_2017, line_counter );
					}


					if ( destination_2017_info[2].trim().isEmpty() || destination_2017_info[2].trim().length() == 0 || destination_2017_info[2].trim() == null ) {

						throw new InvalidDistanceException( FILE_NAME_DESTINATIONS_2017, line_counter );
					}

					distance = Double.parseDouble(destination_2017_info[2]);


					if ( destination_2017_info[3].trim().isEmpty() || destination_2017_info[3].trim().length() == 0 || destination_2017_info[3].trim() == null ) {

						throw new InvalidUrbanException( FILE_NAME_DESTINATIONS_2017, line_counter );
					}


					if ( destination_2017_info[3].trim().equals("Y") )
						urban = true;
					else if ( destination_2017_info[3].trim().equals("N")  )
						urban = false;
					else
						throw new InvalidUrbanException( FILE_NAME_DESTINATIONS_2017, line_counter );



					Destination dest2017 = new Destination( id, destination_2017_info[1], distance, urban );

					if ( dest2017 != null ) {

						//try {

							destination2017_TreeMap.addDestination(dest2017);
							temporaryTreeMap.put(dest2017.getDestinationID(),dest2017);

						/*} catch (DuplicateIDException e) {

							System.out.println(e.getMessage());

						}*/

					}


				} catch ( InvalidIDException | InvalidInputArgumentsException | InvalidDestinationNameException |
						InvalidDistanceException | InvalidUrbanException | NumberFormatException e ) {

					System.out.println(e.getMessage());

				} catch ( ArrayIndexOutOfBoundsException e ){

					System.out.println("*** Reading process failed ( Index out of bounds: " + e.getMessage() + " )." );

				}

			}

		} catch (IOException e) {

			System.out.println(e.getMessage());
		}
		finally {

			try {

				fd_destination_2017.close();

			} catch (IOException e) {

				e.getMessage();

			}
		}


		return destination2017_TreeMap;
	}

}