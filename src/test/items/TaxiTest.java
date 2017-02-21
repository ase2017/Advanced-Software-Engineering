package test.items;

import main.io.DataFileReader;
import main.items.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TaxiTest {
	
	private String trueRegistrationNumber = "AA123AB";
	private String trueDriverName = "John Bend";
	private String trueBrand = "Toyota";
	
	@Test
	public void testWrongLengthRegistrationNumber(){
		
		final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
		String wrongRegistrationNumber = "A1A";
		
		System.setOut(new PrintStream(serialContent));
		new Taxi(wrongRegistrationNumber, trueDriverName, trueBrand);
		
		assertEquals("Error! Wrong registration number (in file taxis.txt in line: "
				+ DataFileReader.line_counter + " ).\r\n", serialContent.toString());
	}
	
	@Test
	public void testWrongPatternRegistrationNumber(){
		
		final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
		String wrongRegistrationNumber = "AA1A";

		System.setOut(new PrintStream(serialContent));
		new Taxi(wrongRegistrationNumber, trueDriverName, trueBrand);
		
		assertEquals("Error! Wrong registration number (in file taxis.txt in line: "
				+ DataFileReader.line_counter + " ).\r\n", serialContent.toString());
		
	}
	
	@Test
	public void testWrongLengthDriverName(){
		
		final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
		String wrongDriverName = "Ja"; //Just checks if driver`s name is between 5 and 30 characters, other check will be implemented in DataFileReaderTest
		
		System.setOut(new PrintStream(serialContent));
		new Taxi(trueRegistrationNumber, wrongDriverName, trueBrand);
		
		assertEquals("Error! Wrong driver`s name (in file taxis.txt in line: "
				+ DataFileReader.line_counter + " ).\r\n", serialContent.toString());
	}

	@Test
	public void testWrongNumberOfWordsDriverName(){

		final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
		String wrongDriverName = "Kadasdsadasdsda"; //If driver`s name less than two words, this should show an error

		System.setOut(new PrintStream(serialContent));
		new Taxi(trueRegistrationNumber, wrongDriverName, trueBrand);

		assertEquals("Error! Wrong driver`s name (in file taxis.txt in line: "
				+ DataFileReader.line_counter + " ).\r\n", serialContent.toString());

	}

	@Test
	public void testNullDriverName(){
		
		final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
		String wrongDriverName = null; //Just checks if driver`s name is between 3 and 30 characters, other check will be implemented in DataFileReaderTest
		
		System.setOut(new PrintStream(serialContent));
		new Taxi(trueRegistrationNumber, wrongDriverName, trueBrand);
		
		assertEquals("Error! Wrong driver`s name (in file taxis.txt in line: "
				+ DataFileReader.line_counter + " ).\r\n", serialContent.toString());
	}

	@Test
	public void testNullBrandName(){
		
		final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
		String wrongBrandName = null;
		
		System.setOut((new PrintStream(serialContent)));
		new Taxi(trueRegistrationNumber, trueDriverName, wrongBrandName);
		
		assertEquals("Error! Wrong car`s brand (in file taxis.txt in line: "
				+ DataFileReader.line_counter + " ).\r\n", serialContent.toString());
	}
	
	@Test
	public void testWrongLengthBrandName(){
		
		final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
		String wrongBrandName = "J";
		
		System.setOut(new PrintStream(serialContent));
		new Taxi(trueRegistrationNumber, trueDriverName, wrongBrandName);
		
		assertEquals("Error! Wrong car`s brand (in file taxis.txt in line: "
				+ DataFileReader.line_counter + " ).\r\n", serialContent.toString());
	}
	
	@Test
	public void testCorrectExample(){
		
		Taxi ex = new Taxi(trueRegistrationNumber, trueDriverName, trueBrand);
		boolean result = ex.equals(null);
		
		assertFalse(result);
	}
}
