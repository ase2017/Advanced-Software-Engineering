package exceptions;

public class InvalidRegistrationNumberException extends Exception{

	public InvalidRegistrationNumberException(String filename, int line){
		
		super("Error! Wrong registration number (in file " + filename + " in line: " + Integer.toString(line) + " ).");
		
	}
	
}
