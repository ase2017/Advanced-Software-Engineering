package main.exceptions;

@SuppressWarnings("serial")
public class DuplicateIDException extends Exception {

	public DuplicateIDException(String filename, int line){
		
		super("Error! Duplicate item ID (in file " + filename + " in line: " + Integer.toString(line) + " ).");
		
	}
	
}
