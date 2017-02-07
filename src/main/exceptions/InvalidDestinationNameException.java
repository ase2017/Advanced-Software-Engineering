package main.exceptions;

@SuppressWarnings("serial")
public class InvalidDestinationNameException extends Exception{

	public InvalidDestinationNameException(String filename, int line){
			
		super("Error! The name of the destination is invalid (in file " + filename + " in line: " + Integer.toString(line) + " ).");
			
	}
}
