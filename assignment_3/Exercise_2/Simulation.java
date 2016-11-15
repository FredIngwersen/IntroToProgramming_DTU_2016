package assignment_3.Exercise_2;

public class Simulation {

	public static final int TRACKSIZE = 80;
	public static final int INNERSIZE = TRACKSIZE / 3;
	public static final int TRACKWIDTH = (TRACKSIZE - INNERSIZE) / 2;

	private int steps;
	private int noOfVehicles;
	private static Vehicle[] vehicles; // Array containing the vehicles

	/**
	 * Constructor. Initializes the data structures and the graphics.
	 * 
	 * @param noOfVehicles
	 *            The number of vehicles.
	 * @param steps
	 *            The number of steps, the simulation should run.
	 */
	public Simulation(int noOfVehicles, int steps) {
		this.noOfVehicles = noOfVehicles;
		this.steps = steps;
		init();
	}

	/**
	 * Public method which performs the simulation.
	 */

	public void run() {
		// During each execution of the loop one step is of the
		// simulation is performed.
		for (int i = 0; i < steps; i++) {
			// Draw an empty track.
			drawEmptyTrack();
			// Loop over all vehicles
			for (int j = 0; j < vehicles.length; j++) {
				// Draw and then move a vehicles
				drawVehicle(vehicles[j]);
				//vehicles[j].move();
			}
			// show the new situation and pause 100 milliseconds
			StdDraw.show(100);

		}
	}

	/**
	 * Draws a single vehicle. The position and appearance are determined by
	 * querying the vehicle.
	 * 
	 * @param vehicle
	 *            The vehicle to be drawn.
	 */
	private void drawVehicle(Vehicle vehicle) {
		StdDraw.setPenColor(vehicle.getColor());
		StdDraw.filledSquare(vehicle.getPosition().x, vehicle.getPosition().y, vehicle.getSize());
	}

	/**
	 * Initializes the graphics and creates the vehicles.
	 */
	private void init() {
		StdDraw.setXscale(-1, TRACKSIZE + 1);
		StdDraw.setYscale(-1, TRACKSIZE + 1);
		StdDraw.setPenRadius(0.9 / (TRACKSIZE + 1));
		drawEmptyTrack();

		createVehicles();

	}

	/**
	 * Creates the vehicles and stores them in the array "vehicles". Roughly 1/3
	 * are trucks, family cars and sport cars. One drunken driver is added.
	 */
	private void createVehicles() {
		// create an array of type Vehicle
		vehicles = new Vehicle[noOfVehicles];
		// fill the array
		for (int i = 0; i < vehicles.length / 3; i++) {
			vehicles[i] = new Truck();
		}
		for (int i = vehicles.length / 3; i < 2 * vehicles.length / 3; i++) {
			vehicles[i] = new FamilyCar();
		}
		for (int i = 2 * vehicles.length / 3; i < vehicles.length - 1; i++) {
			vehicles[i] = new Bus();
		}
		vehicles[vehicles.length - 1] = new DrunkenDriver();
	}

	/**
	 * Draws an empty track
	 */
	private void drawEmptyTrack() {
		StdDraw.clear(StdDraw.GRAY);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledSquare((TRACKSIZE) / 2.0, (TRACKSIZE) / 2.0,
				TRACKSIZE / 2.0);
		StdDraw.setPenColor(StdDraw.GRAY);
		StdDraw.filledSquare(TRACKSIZE / 2.0, TRACKSIZE / 2.0, INNERSIZE / 2.0);

	}

}
