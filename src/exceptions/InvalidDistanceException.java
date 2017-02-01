package exceptions;

public class InvalidDistanceException extends Exception{

	public InvalidDistanceException(String filename, int line){
		
		super("Error! The distance is not in the correct range (in file " + filename + " in line: " + Integer.toString(line) + " ).");
		
	}
}
