package exceptions;

public class InvalidTimeException extends Exception{

	public InvalidTimeException(String filename, int line){
		
		super("Error! The time of the journey is not in the correct format "
				+ "(in file " + filename + " in line: " + Integer.toString(line) + " ).");
		
	}
	
}
