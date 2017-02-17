package test.view;

import main.view.*;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class MenuDisplayerTest {
	
	@Test
	public void showMenuTest(){
		
		String expectedMenuContent = "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n\r\n\t 1."
				+ " Create output files.\r\n\t 2. Exit.\n\r\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"
				+ "%%%%%%%%%%%\n\r\n";
		
		final ByteArrayOutputStream serialContent = new ByteArrayOutputStream();
		
		System.setOut(new PrintStream(serialContent));
		MenuDisplayer md = new MenuDisplayer();
		md.displayMainMenu();
		
		assertEquals(expectedMenuContent, serialContent.toString());
	}
}
