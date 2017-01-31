import java.util.Scanner;
import items.TaxiData;
import view.MenuDisplayer;


public class TaxiService {
		

	public TaxiData taxidata;
	
	
	public void start(){

		taxidata = new TaxiData();
		
		this.mainMenu();
	}
	
	
	private boolean readFiles(){
		
		return false;
	}
	
	
	
	private void mainMenu() {
		
		int choice = 0;
		Scanner scan = new Scanner(System.in);      
		
		MenuDisplayer menu = new MenuDisplayer();
		
		
		
		while ( choice >= 0 && choice <= 2  ) {
			
			
			menu.displayMainMenu();
			
			
			System.out.println("\n\t Type your choice: ");
			choice = scan.nextInt();
			
			
			switch ( choice ) {
				
				case 1:
					System.out.println("\t \nUser typed 1.\n");
					break;
				
				case 2:
					System.out.println("\t \nUser typed 2.\n");
					break;
				
				case 3:
					System.out.println("\t \nExit.\n");
					break;
				
				default:
					System.out.println("\t \nPlease, try again...\n");
					break;
			}
			
		}
		
		
		
	}
	
	private void exit(boolean problem){
		
	}
	
	private void writeFiles(){
		
	}

}
