package week8.VesselFolder;

public class GlasBottle extends Bottle{

	private String color;

	public GlasBottle(int volume, String content, String color) {
		super(volume, content);
		this.color = color;
	}

	public String toString(){
		return "This " + color + " glas bottle has a volume of " + getVolume() 
		+ " and contains " + getContent(); 
	}

}
