package main;

import java.util.Scanner;
import main.io.DataFileReader;
import main.io.DataFileWriter;
import main.items.TaxiData;
import main.view.MenuDisplayer;

public class TaxiService {

	public TaxiData taxidata;

	public void start() {

		taxidata = new TaxiData();
		this.mainMenu();
	}

	private boolean readFiles() {

		System.out.print("\n");
		DataFileReader fr = new DataFileReader();

		try{
			taxidata.setTaxis(fr.loadTaxis());
		}
		catch(Exception e){
			//System.out.println(e.getMessage());
		}
		
		//taxidata.setJourneys(fr.loadJourney());
		//taxidata.setPreviousYearDestinations(fr.loadDestinations2016());
		//taxidata.setCurrentYearDestinations(fr.loadDestinations2017());

		try {
			if (taxidata.getCurrentYearDestinations().getDestinations().size() > 0 && taxidata.getJourneys().getJourneys().size() > 0
					&& taxidata.getPreviousYearDestinations().getDestinations().size() > 0 && taxidata.getTaxis().getTaxis().size() > 0) {
				
				return true;
			} else {

				System.out.println("no");
			}
		} catch (Exception e) {
			return false;
		}

		return false;

	}

	private void mainMenu() {

		Scanner scan = new Scanner(System.in);
		MenuDisplayer menu = new MenuDisplayer();
		int choice = 0;

		while (choice >= 0 && choice <= 3) {

			menu.displayMainMenu();
			System.out.print("\n\t Type your choice: ");
			choice = scan.nextInt();

			switch (choice) {

			case 1:
				if (readFiles()) {
					// writeFiles();
				} else {
					exit("\nError! No files found.");
				}
				break;

			case 2:
				exit("\t See you later!\n");
				scan.close();
				break;

			default:
				System.out.println("\t \nPlease, try again...\n");
				break;
			}
		}
	}

	private void exit(String message) {

		System.out.println(message);
		System.exit(0);

	}

	private void writeFiles() {

		DataFileWriter fw = new DataFileWriter();

	}
}
