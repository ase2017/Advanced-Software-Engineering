package items;

public class Taxi {
	
	private String registrationName;
	private String driverName;
	
	public Taxi(String registrationName, String driverName) {
		this.registrationName = registrationName;
		this.driverName = driverName;
	}
	public String getRegistrationName() {
		return registrationName;
	}
	public void setRegistrationName(String registrationName) {
		this.registrationName = registrationName;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	
	

}
