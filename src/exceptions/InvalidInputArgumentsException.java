package exceptions;

public class InvalidInputArgumentsException extends Exception{

	public InvalidInputArgumentsException(String filename, int line){
		
		super("Error! The input arguements are invalid (in file " + filename + " in line: " + Integer.toString(line) + " ).");
		
	}
}
