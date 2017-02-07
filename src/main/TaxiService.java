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
			taxidata.setJourneys(fr.loadJourney());
			taxidata.setCurrentYearDestinations(fr.loadDestinations2017());
			taxidata.setPreviousYearDestinations(fr.loadDestinations2016());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}

		//System.out.println(taxidata.getTaxis().getTaxis().size());
		//System.out.println(taxidata.getJourneys().getJourneys().size());
		//System.out.println(taxidata.getCurrentYearDestinations().getDestinations().size());
		//System.out.println(taxidata.getPreviousYearDestinations().getDestinations().size());


		//taxidata.setJourneys(fr.loadJourney());
		//taxidata.setPreviousYearDestinations(fr.loadDestinations2016());
		//taxidata.setCurrentYearDestinations(fr.loadDestinations2017());


			if (	taxidata != null && taxidata.getTaxis() != null && taxidata.getCurrentYearDestinations() != null
					&& taxidata.getPreviousYearDestinations() != null && taxidata.getJourneys() != null
					&& taxidata.getTaxis().getTaxis() != null && taxidata.getPreviousYearDestinations().getDestinations() != null
					&& taxidata.getJourneys().getJourneys() != null && taxidata.getCurrentYearDestinations() != null
					&& taxidata.getCurrentYearDestinations().getDestinations().size() > 0 && taxidata.getJourneys().getJourneys().size() > 0
					&& taxidata.getPreviousYearDestinations().getDestinations().size() > 0 && taxidata.getTaxis().getTaxis().size() > 0) {

				return true;
			} else {

				System.out.println("no");
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

		System.out.println("Write files called");

		DataFileWriter df = new DataFileWriter();
		df.writeFiles(taxidata);


	}
}