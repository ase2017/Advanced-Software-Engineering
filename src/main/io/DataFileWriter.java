package main.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import main.items.TaxiData;


public class DataFileWriter {
	
	private static final String OUTPUT_DIRECTORY_NAME = "outputFiles/";
	private static final String FILE_NAME_TOP_5 = "top-5.txt";
	private static final String FILE_NAME_PLACES_PER_DRIVER = "driver-Journeys.txt";
	private static final String FILE_NAME_PLACES = "visited-Places.txt";

	public void writeFiles(TaxiData taxidata) {

		boolean file1_OK = false;
		boolean file2_OK = false;
		boolean file3_OK = false;

		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("\nCreating output files...\n");

		file1_OK = writeFile1(taxidata);
		file2_OK = writeFile2(taxidata);
		file3_OK = writeFile3(taxidata);


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


		if ( file1_OK && file1_OK && file1_OK )
			System.out.println("\nProcess completed!!!");
		else
			System.out.println("\nProcess ended with errors...");


		System.out.println("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");

	}


	private boolean writeFile1(TaxiData taxidata) {


		BufferedWriter buffWriterFile1 = null;
		FileWriter fileWriterFile1 = null;

		try {

			String fileContents = "";

			fileWriterFile1 = new FileWriter( OUTPUT_DIRECTORY_NAME + FILE_NAME_TOP_5 );
			buffWriterFile1 = new BufferedWriter(fileWriterFile1);


			fileContents = taxidata.formatMostExpensiveJourneys(5);
			buffWriterFile1.write(fileContents);
			System.out.println(fileContents);

			fileContents = taxidata.formatLessExpensiveJourneys(5);
			buffWriterFile1.write(fileContents);

		} catch (IOException e) {

			System.out.println(e.getMessage());
			return false;

		} finally {

			try {

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


	private boolean writeFile2(TaxiData taxidata) {


		BufferedWriter buffWriterFile2 = null;
		FileWriter fileWriterFile2 = null;

		try {

			String fileContents = "";

			fileWriterFile2 = new FileWriter( OUTPUT_DIRECTORY_NAME + FILE_NAME_PLACES_PER_DRIVER );
			buffWriterFile2 = new BufferedWriter(fileWriterFile2);

			buffWriterFile2.write(fileContents);

			fileContents = taxidata.formatPlacesVisitedPerDriver();
			buffWriterFile2.write(fileContents);


		} catch (IOException e) {

			System.out.println(e.getMessage());
			return false;

		} finally {

			try {

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



	private boolean writeFile3(TaxiData taxidata) {


		BufferedWriter buffWriterFile3 = null;
		FileWriter fileWriterFile3 = null;

		try {

			String fileContents = "";

			fileWriterFile3 = new FileWriter( OUTPUT_DIRECTORY_NAME + FILE_NAME_PLACES );
			buffWriterFile3 = new BufferedWriter(fileWriterFile3);

			buffWriterFile3.write(fileContents);

			fileContents = taxidata.formatPlacesVisited();
			buffWriterFile3.write(fileContents);


		} catch (IOException e) {

			System.out.println(e.getMessage());
			return false;

		} finally {

			try {

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