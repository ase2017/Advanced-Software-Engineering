package exceptions;

public class InvalidTaxiNameException extends Exception{

	public InvalidTaxiNameException(String filename, int line){
		
		super("Error! Wrong driver`s name (in file " + filename + " in line: " + Integer.toString(line) + " ).");
		
	}
}
