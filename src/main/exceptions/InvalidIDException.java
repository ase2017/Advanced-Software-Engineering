package main.exceptions;

@SuppressWarnings("serial")
public class InvalidIDException extends Exception {

	public InvalidIDException(String filename, int line){
		
		super("Error! Invalid record`s ID (in file " + filename + " in line: " + Integer.toString(line) + " ).");
		
	}
	
}