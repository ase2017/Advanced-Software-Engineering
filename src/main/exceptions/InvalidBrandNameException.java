package main.exceptions;

@SuppressWarnings("serial")
public class InvalidBrandNameException extends Exception{

	public InvalidBrandNameException(String filename, int line){

		super("Error! Wrong car`s brand (in file " + filename + " in line: " + Integer.toString(line) + " ).");

	}

}