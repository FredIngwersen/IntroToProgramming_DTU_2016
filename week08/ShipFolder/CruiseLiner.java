package week08.ShipFolder;

public class CruiseLiner extends Ship{
	
	private int noOfPassengers;
	
	public CruiseLiner(String name, int length, int noOfPassengers) {
		super(name, length);
		this.noOfPassengers = noOfPassengers;
	}

	public String toString(){
		return super.toString() + " cruise liner with " +
				noOfPassengers + " passenger capacity";
	}
}
