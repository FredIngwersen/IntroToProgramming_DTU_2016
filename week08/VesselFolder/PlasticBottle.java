package week08.VesselFolder;

public class PlasticBottle extends Bottle{

	private String material;

	public PlasticBottle(int volume, String content, String material) {
		super(volume, content);
		if(material == "PET"){
			this.material = material;
		} else {
			this.material = "OTHER";
		}
	}

	public String toString(){
		return "This " + material + " bottle has a volume of " + getVolume() 
		+ " and contains " + getContent(); 
	}


}
