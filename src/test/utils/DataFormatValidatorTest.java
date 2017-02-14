package test.utils;

import static org.junit.Assert.*;
import org.junit.*;

import main.TaxiService;
import main.io.DataFileReader;
import main.items.TaxiData;
import main.utils.DataFormatValidator;



public class DataFormatValidatorTest {
	
	
	
	@Test
	public void validateRegistrationNumber () {
		
		String regNumberLegal = "AA743HE"; 
		String regNumberEmpty = "";
		String regNumberNull = null;
		String regNumberTest1 = "AAAAAAA";
		String regNumberTest2 = "123";
		String regNumberTest3 = "12345678910";
		
		
		assertTrue( "Invalid length of Registration Number " + regNumberLegal, DataFormatValidator.validateRegistrationNumber(regNumberLegal) );
		
		assertTrue( "Invalid length of Registration Number " + regNumberTest1,  DataFormatValidator.validateRegistrationNumber(regNumberLegal) );
		
		assertFalse( "Invalid length of Registration Number " + regNumberNull,  DataFormatValidator.validateRegistrationNumber(regNumberNull) );
		
		assertFalse( "Invalid length of Registration Number " + regNumberEmpty,  DataFormatValidator.validateRegistrationNumber(regNumberEmpty) );
		
		assertFalse( "Invalid length of Registration Number " + regNumberTest2,  DataFormatValidator.validateRegistrationNumber(regNumberTest2) );
		
		assertFalse( "Invalid length of Registration Number " + regNumberTest3, DataFormatValidator.validateRegistrationNumber(regNumberTest3) );
		
	}
	
	
	@Test
	public void validateDriverName() {
		
		
		String driverNameLegal = "Peter Parker";
		String driverNameEmptyName = "";
		String driverNameNull = null;
		String driverNameFirstName = "Peter";
		String driverNameLastName = "Parker";
		String driverNameMiddleName = "Peter D. Parker";
		String driverNameRandom = "A new taxi driver's name with length more than 30 characters!";
		
		
		assertTrue("Driver Name is out of range: " + driverNameLegal, DataFormatValidator.validateDestinationName(driverNameLegal));
		
		assertTrue("Driver Name is out of range: " + driverNameFirstName,  DataFormatValidator.validateDestinationName(driverNameFirstName) );
		
		assertTrue("Driver Name is out of range: " + driverNameLastName,  DataFormatValidator.validateDestinationName(driverNameLastName) );
		
		assertTrue("Driver Name is out of range: " + driverNameMiddleName,  DataFormatValidator.validateDestinationName(driverNameMiddleName) );
		
		assertFalse("Driver Name is out of range: " + driverNameEmptyName,  DataFormatValidator.validateDestinationName(driverNameEmptyName) );
		
		assertFalse("Driver Name is out of range: " + driverNameRandom,  DataFormatValidator.validateDestinationName(driverNameRandom) );
		
		assertFalse("Driver Name is out of range: " + driverNameNull,  DataFormatValidator.validateDestinationName(driverNameNull) );
		
		
	}
	
	
	@Test 
	public void validateBrand() {
		
		String brandNameLegal = "Mercedes";
		String brandNameEmpty = "";
		String brandNameNull = null;
		String brandNameTest1 = "X";
		String brandNameTest2 = "A brand name with more than 15 characters!";
		
		
		assertTrue("Brand Name is out of range: " + brandNameLegal, DataFormatValidator.validateBrand(brandNameLegal) );
		
		assertFalse("Brand Name is out of range: " + brandNameEmpty, DataFormatValidator.validateBrand(brandNameEmpty) );
		
		assertFalse("Brand Name is out of range: " + brandNameNull, DataFormatValidator.validateBrand(brandNameNull) );
		
		assertFalse("Brand Name is out of range: " + brandNameTest1, DataFormatValidator.validateBrand(brandNameTest1) );
		
		assertFalse("Brand Name is out of range: " + brandNameTest2, DataFormatValidator.validateBrand(brandNameTest2) );
		
		
		
	}
	
	
	@Test
	public void validateDestinationName() {
		
		String destinationLegal = "Heriot-Watt";
		String destinationEmpty = "";
		String destinationNull = null;
		String destinationTest1 = "X";
		String destinationTest2 = "This is a destination name with more tha 30 characters!";
		
		assertTrue("Destination name is out of range: " + destinationLegal, DataFormatValidator.validateDestinationName(destinationLegal));
		
		assertFalse("Destination name is out of range: " + destinationEmpty, DataFormatValidator.validateDestinationName(destinationEmpty));
		
		assertFalse("Destination name is out of range: " + destinationNull, DataFormatValidator.validateDestinationName(destinationNull));
		
		assertFalse("Destination name is out of range: " + destinationTest1, DataFormatValidator.validateDestinationName(destinationTest1));
		
		assertFalse("Destination name is out of range: " + destinationTest2, DataFormatValidator.validateDestinationName(destinationTest2));
		
		
	}
	
	
	@Test
	public void validateDistance () {
		
		double distanceLegal = 13.0;
		double distanceZero = 0.0;
		double distanceNegative = -10.0;
		double distanceTooLong = 1000.0;
		
		
		assertTrue("Distance is out of range: " + distanceLegal , DataFormatValidator.validateDistance(distanceLegal));
		
		assertFalse("Distance is out of range: " + distanceZero , DataFormatValidator.validateDistance(distanceZero));
		
		assertFalse("Destination name is out of range: " + distanceNegative , DataFormatValidator.validateDistance(distanceNegative));
		
		assertFalse("Destination name is out of range: " + distanceTooLong , DataFormatValidator.validateDistance(distanceTooLong));
		
	}
	
	
	@Test
	public void validatePassengerNumber() {
		
		int numOfPassengersLegal = 2;
		int numOfPassengersZero = 0;
		int numOfPassengersNegative = -3;
		int numOfPassengersTooMany = 100;
		
		
		assertTrue("Passengers Number out of range" + numOfPassengersLegal , DataFormatValidator.validatePassengerNumber(numOfPassengersLegal));
		
		assertFalse("Passengers Number out of range" + numOfPassengersZero, DataFormatValidator.validatePassengerNumber(numOfPassengersZero));
		
		assertFalse("Passengers Number out of range" + numOfPassengersNegative, DataFormatValidator.validatePassengerNumber(numOfPassengersNegative));
		
		assertFalse("Passengers Number out of range" + numOfPassengersTooMany, DataFormatValidator.validatePassengerNumber(numOfPassengersTooMany));
		
	}
	
	
	@Test
	public void validateUrban() {
		
		String urbanLegal = "Y";
		String urbanEmpty = "";
		String urbanTest = "Not Legal Urban string!";
		String urbanNull = null;
		
		
		assertTrue("Invalid Urban area expression: " + urbanLegal, DataFormatValidator.validateUrban(urbanLegal));
		
		assertFalse("Invalid Urban area expression: " + urbanEmpty, DataFormatValidator.validateUrban(urbanEmpty));
		
		assertFalse("Invalid Urban area expression: " + urbanTest, DataFormatValidator.validateUrban(urbanTest));
		
		assertFalse("Invalid Urban area expression: " + urbanNull, DataFormatValidator.validateUrban(urbanNull));
		
		
	}
	
	
	@Test
	public void validateDestinationID() {
		
		int idLegal = 400;
		int idZero = 0;
		int idNegative = -3;
		
		assertTrue("ID out of range: " + idLegal, DataFormatValidator.validateDestinationID(idLegal));
		
		assertFalse("ID out of range: " + idZero, DataFormatValidator.validateDestinationID(idZero));
		
		assertFalse("ID out of range: " + idNegative, DataFormatValidator.validateDestinationID(idNegative));
		
	}
	
	
}
