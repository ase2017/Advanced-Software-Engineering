package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import main.io.DataFileReader;
import main.io.DataFileWriter;
import main.items.Journey;
import main.items.TaxiData;
import main.view.MenuDisplayer;

public class TaxiService {

	public TaxiData taxidata;
	public static int TOTAL_TRIES_BEFORE_EXIT = 3;

	public void start() {

		taxidata = new TaxiData();
		this.mainMenu();
	}

	private boolean readFiles() {

		System.out.print("\n");
		DataFileReader fr = new DataFileReader();

		try {
			taxidata.setTaxis(fr.loadTaxis());
			taxidata.setJourneys(fr.loadJourney());
			taxidata.setCurrentYearDestinations(fr.loadDestinations2017());
			taxidata.setPreviousYearDestinations(fr.loadDestinations2016());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (taxidata != null && taxidata.getTaxis() != null && taxidata.getCurrentYearDestinations() != null
				&& taxidata.getPreviousYearDestinations() != null && taxidata.getJourneys() != null
				&& taxidata.getTaxis().getTaxis() != null
				&& taxidata.getPreviousYearDestinations().getDestinations() != null
				&& taxidata.getJourneys().getJourneys() != null && taxidata.getCurrentYearDestinations() != null
				&& taxidata.getCurrentYearDestinations().getDestinations().size() > 0
				&& taxidata.getJourneys().getJourneys().size() > 0
				&& taxidata.getPreviousYearDestinations().getDestinations().size() > 0
				&& taxidata.getTaxis().getTaxis().size() > 0) {

			return true;
			
		} else {

			exit("\t \n Not enough records.");
		}

		return false;
	}

	private void mainMenu() {

		Scanner scan = new Scanner(System.in);
		MenuDisplayer menu = new MenuDisplayer();
		
		int choice = 0;
		int error_counter = 0;
		
		while (error_counter != TOTAL_TRIES_BEFORE_EXIT) {

			menu.displayMainMenu();
			System.out.print("\n\t Type your choice: ");

			try {
				
				choice = scan.nextInt();
				
				switch (choice) {		

				case 1:
					
					error_counter = 0;
					if (readFiles()) {
						writeFiles();
					} else {
						exit("\nError! No files found.");
					}
					break;

				case 2:
					exit("\t See you later!\n");
					scan.close();
					break;

				default:
					error_counter++;
					System.out.println("\t \nInvalid argument! Your choice has to be a number between 1-2.");
					break;
					
				}
			} catch (InputMismatchException e) {
				scan.nextLine();
				error_counter++;
				System.out.println("\t \nInvalid argument! Your choice has to be a number between 1-2.");
			}		
		}
	}

	private void exit(String message) {

		System.out.println(message);
		System.exit(0);

	}

	private void writeFiles() {

		DataFileWriter df = new DataFileWriter();
		df.writeFiles(taxidata);

	}
}