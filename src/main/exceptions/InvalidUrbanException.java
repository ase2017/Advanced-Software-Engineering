package main.exceptions;

@SuppressWarnings("serial")
public class InvalidUrbanException extends Exception {

 public InvalidUrbanException (String filename, int line){
  
  super("Error! Wrong urban area (in file " + filename + " in line: " + Integer.toString(line) + " ).");
  
 }
}