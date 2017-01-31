package items;

public class Taxi {

	private String registrationNumber;
	private String driverName;
	private String brand;
	
	public Taxi(String registrationNumber, String driverName, String brand){
		
		this.registrationNumber = registrationNumber;
		this.driverName = driverName;
		this.brand = brand;
		
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

