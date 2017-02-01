package exceptions;

public class InvalidNumberOfPassengersException extends Exception{

	public InvalidNumberOfPassengersException(String filename, int line){
		
		super("Error! The number of passengers is not correct (in file " + filename + " in line: " + Integer.toString(line) + " ).");
		
	}
	
}
