package week8.ShipFolder;

public class ContainerShip extends Ship{

	private int teu;
	
	public ContainerShip(String name, int length, int teu) {
		super(name, length);
		this.teu = teu;
	}
	public String toString(){
		return super.toString() + " container carrier with "
				+ teu + " TEU";
	}
}
