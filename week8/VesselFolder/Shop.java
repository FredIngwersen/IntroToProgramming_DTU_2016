package week8.VesselFolder;

public class Shop {

	private static int size = 6;
	private static int nextFree;
	private static Vessel[] storage;

	public static void main(String[] args) {
		storage = new Vessel[size];
		nextFree = 0;
		createVessels();
		listStorage();

	}

	private static void listStorage() {
		for (int i = 0; i < storage.length; i++) {
			if(storage[i] != null){
				System.out.println(storage[i]);
			}
		}

	}

	private static void createVessels() {
		Vessel v = new Vessel(1);
		addToStorage(v);
		Bottle b = new Bottle(1,"juice");
		addToStorage(b);
		GlasBottle gb1 = new GlasBottle(2,"juice","green");
		addToStorage(gb1);
		GlasBottle gb2 = new GlasBottle(1,"beer","white");
		addToStorage(gb2);
		PlasticBottle pb1 = new PlasticBottle(2,"cola","PP");
		addToStorage(pb1);
		PlasticBottle pb2 = new PlasticBottle(1,"milk","PET");
		addToStorage(pb2);
		PlasticBottle pb3 = new PlasticBottle(3,"cola","PP");
		addToStorage(pb3);
	}

	private static void addToStorage(Vessel v) {
		if (nextFree < size) {
			storage[nextFree] = v;
			nextFree++;
		}else{
			System.out.println("Storage full");
		}

	}

}