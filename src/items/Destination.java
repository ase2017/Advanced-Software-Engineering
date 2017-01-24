package items;

public class Destination {
	private String name;
	private double distance;
	
	public Destination(){
		
	}
	public Destination(String name, double distance) {
		this.name = name;
		this.distance = distance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	
}

