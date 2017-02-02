package main.items;

import main.exceptions.InvalidBrandNameException;
import main.exceptions.InvalidRegistrationNumberException;
import main.exceptions.InvalidTaxiNameException;
import main.io.DataFileReader;
import main.utils.DataFormatValidator;

public class Taxi {

	private String registrationNumber;
	private String driverName;
	private String brand;
	
	public Taxi(String registrationNumber, String driverName, String brand){
		
		this.registrationNumber = registrationNumber;
		this.driverName = driverName;
		this.brand = brand;
		
		/* Checks */
		
		try{
			
			if ( !DataFormatValidator.validateRegistrationNumber(registrationNumber)) 
				throw new InvalidRegistrationNumberException(DataFileReader.FILE_NAME_TAXIS, DataFileReader.line_counter);		
			
			if ( !DataFormatValidator.validateDriverName(driverName)) 
				throw new InvalidTaxiNameException(DataFileReader.FILE_NAME_TAXIS, DataFileReader.line_counter);
				
			if ( !DataFormatValidator.validateBrand(brand))		
				throw new InvalidBrandNameException(DataFileReader.FILE_NAME_TAXIS, DataFileReader.line_counter);
			
		} catch(InvalidRegistrationNumberException | InvalidTaxiNameException | 
				InvalidBrandNameException e){
			
			System.out.println(e.getMessage());
			
		}	
		
		/* End of checks */
	}

	/* Getters and Setters */
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
}

