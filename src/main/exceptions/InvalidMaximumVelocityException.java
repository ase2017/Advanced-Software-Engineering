package main.exceptions;

public class InvalidMaximumVelocityException extends Exception{

	public InvalidMaximumVelocityException(String filename, int line){
		
		super("Error! The maximum velocity is not in the correct range"
				+ " (in file " + filename + " in line: " + Integer.toString(line) + " ).");
		
	}
	
}
