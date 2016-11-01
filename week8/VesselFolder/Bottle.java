package week8.VesselFolder;

public class Bottle extends Vessel{

	private String content;

	public Bottle(int volume, String content) {
		super(volume);
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String toString(){
		return "This bottle has a volume of " + getVolume() + " and contains " + content;
	}
}
