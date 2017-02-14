package main.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import main.items.TaxiData;


/**
 * DataFileWriter is a public class that writes the computation result 
 * to three output files <top-5.txt>, <driver-Journeys.txt> 
 * and <visited-Places.txt>
 * 
 * @author Chiotis
 *
 */
public class DataFileWriter {

	private static final String OUTPUT_DIRECTORY_NAME = "outputFiles";
	private static final String FILE_NAME_TOP_5 = "top-5.txt";
	private static final String FILE_NAME_PLACES_PER_DRIVER = "driver-Journeys.txt";
	private static final String FILE_NAME_PLACES = "visited-Places.txt";

	/**
	 * writeFiles is a public method that takes the appropriate Stings
	 * from TaxiData, call the three methods that creates the output files
	 * and finally checks if the process ended successfully. 
	 * 
	 * @param taxidata contains the Strings that we will write to the output files.
	 */
	public void writeFiles(TaxiData taxidata) {

		boolean file1_OK = false;
		boolean file2_OK = false;
		boolean file3_OK = false;

		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("\nCreating output files...\n");

		// Creates the output Directory, if does not exists.
		File f = new File(OUTPUT_DIRECTORY_NAME);
		if (!f.isDirectory()) {
			f.mkdir();
		}

		// Call the three methods in order to create the three output files.
		file1_OK = writeFile1(taxidata);
		file2_OK = writeFile2(taxidata);
		file3_OK = writeFile3(taxidata);


		// Inform user whether the process was successful or not. 
		if ( file1_OK )
			System.out.println("\t+ <" + FILE_NAME_TOP_5 + "> successfully created!");
		else
			System.out.println("\t->Error occured in " + FILE_NAME_TOP_5 + "...");

		if ( file2_OK )
			System.out.println("\t+ <" + FILE_NAME_PLACES_PER_DRIVER + "> successfully created!");
		else
			System.out.println("\t->Error occured in " + FILE_NAME_PLACES_PER_DRIVER + "...");

		if ( file3_OK )
			System.out.println("\t+ <" + FILE_NAME_PLACES + "> successfully created!");
		else
			System.out.println("\t->Error occured in " + FILE_NAME_PLACES + "...");


		if ( file1_OK && file2_OK && file3_OK )
			System.out.println("\nProcess completed!!!");
		else
			System.out.println("\nProcess ended with errors...");


		System.out.println("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");

	}


	/**
	 * writeFile1 creates the top-5 output file if does not already exists
	 * and write the resulted string from TaxiData.
	 * 
	 * @param taxidata contains the String needed for the top-5 journey's output file.
	 * 
	 * @return true if process ended successfully
	 * 	       else return false.
	 */
	private boolean writeFile1(TaxiData taxidata) {


		BufferedWriter buffWriterFile1 = null;
		FileWriter fileWriterFile1 = null;

		try {

			String fileContents = "";

			// Open the FILE_NAME_TOP_5 (instance variable) file.
			fileWriterFile1 = new FileWriter( OUTPUT_DIRECTORY_NAME + "/" + FILE_NAME_TOP_5 );
			buffWriterFile1 = new BufferedWriter(fileWriterFile1);

			
			fileContents = taxidata.formatJourneyFile();	// Takes the resulted data from the Taxi's Data object. 
			buffWriterFile1.write(fileContents);			// Writes the data to the file


		} catch (IOException e) {

			System.out.println(e.getMessage());
			return false;

		} finally {

			try {
				
				// Close the file descriptors.

				if (buffWriterFile1 != null)
					buffWriterFile1.close();

				if (fileWriterFile1 != null)
					fileWriterFile1.close();

			} catch (IOException e) {

				System.out.println(e.getMessage());
				return false;

			}

		}


		return true;
	}


	/**
	 * writeFile2 creates the driver's Journey output file if does not already exists
	 * and write the resulted string from TaxiData.
	 * 
	 * @param taxidata contains the String needed for the top-5 driver's Journey output file.
	 * 
	 * @return true if process ended successfully
	 * 	       else return false.
	 */
	private boolean writeFile2(TaxiData taxidata) {


		BufferedWriter buffWriterFile2 = null;
		FileWriter fileWriterFile2 = null;

		try {

			String fileContents = "";

			// Open the FILE_NAME_PLACES_PER_DRIVER (instance variable) file.
			fileWriterFile2 = new FileWriter( OUTPUT_DIRECTORY_NAME + "/" + FILE_NAME_PLACES_PER_DRIVER );
			buffWriterFile2 = new BufferedWriter(fileWriterFile2);

			//buffWriterFile2.write(fileContents);

			fileContents = taxidata.formatPlacesVisitedPerDriver();		// Takes the resulted data from the Taxi's Data object. 
			buffWriterFile2.write(fileContents);						// Writes the data to the file.
				

		} catch (IOException e) {

			System.out.println(e.getMessage());
			return false;

		} finally {

			try {

				// Close the file descriptors. 
				if (buffWriterFile2 != null)
					buffWriterFile2.close();

				if (fileWriterFile2 != null)
					fileWriterFile2.close();

			} catch (IOException e) {

				System.out.println(e.getMessage());
				return false;

			}

		}


		return true;

	}


	/**
	 * writeFile3 creates the visited Places output file if does not already exists
	 * and write the resulted string from TaxiData.
	 * 
	 * @param taxidata contains the String needed for the visited Places by taxis output file.
	 * 
	 * @return true if process ended successfully
	 * 	       else return false.
	 */
	private boolean writeFile3(TaxiData taxidata) {


		BufferedWriter buffWriterFile3 = null;
		FileWriter fileWriterFile3 = null;

		try {

			String fileContents = "";

			fileWriterFile3 = new FileWriter( OUTPUT_DIRECTORY_NAME + "/" + FILE_NAME_PLACES );
			buffWriterFile3 = new BufferedWriter(fileWriterFile3);

			// buffWriterFile3.write(fileContents);

			fileContents = taxidata.formatPlacesVisited();		// Takes the resulted data from the Taxi's Data object. 
			buffWriterFile3.write(fileContents);				// Writes the data to the file.


		} catch (IOException e) {

			System.out.println(e.getMessage());
			return false;

		} finally {

			try {

				// Close the file descriptors.
				if (buffWriterFile3 != null)
					buffWriterFile3.close();

				if (fileWriterFile3 != null)
					fileWriterFile3.close();

			} catch (IOException e) {

				System.out.println(e.getMessage());
				return false;

			}

		}


		return true;

	}




}