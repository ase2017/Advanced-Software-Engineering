package main.exceptions;

@SuppressWarnings("serial")
public class InvalidDriverNameException extends Exception{

	public InvalidDriverNameException(String filename, int line){
		
		super("Error! Wrong driver`s name (in file " + filename + " in line: " + Integer.toString(line) + " ).");
		
	}
}
