package week08.VesselFolder;

public class Vessel {

	private int volume;

	public Vessel(int volume){
		this.setVolume(volume);
	}

	public String toString(){
		return "This vessel has a volume of " + getVolume();
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
}
