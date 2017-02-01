package items;

import exceptions.InvalidBrandNameException;
import exceptions.InvalidRegistrationNumberException;
import exceptions.InvalidTaxiNameException;
import io.DataFileReader;
import utils.DataFormatValidator;

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
			
			if ( !DataFormatValidator.validateRegistrationNumber(registrationNumber) ) {
				
				throw new InvalidRegistrationNumberException(DataFileReader.FILE_NAME_TAXIS, 0);
			}
			
			if ( !DataFormatValidator.validateDriverName( driverName )) {
				
				throw new InvalidTaxiNameException(DataFileReader.FILE_NAME_TAXIS, 0);
				
			}
			if ( !DataFormatValidator.validateBrand( brand)) {
				
				throw new InvalidBrandNameException(DataFileReader.FILE_NAME_TAXIS, 0);
			}
			
			
		} catch(InvalidRegistrationNumberException | InvalidTaxiNameException | 
				InvalidBrandNameException e){
			
			//e.toString();
			
		}		
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

