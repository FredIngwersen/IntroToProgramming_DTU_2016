import java.awt.*;

/**
 * Created by William Ben Embarek on 14/11/2016.
 */
public class DrunkenDriver extends Vehicle {
	Point position = getPosition();
	Boolean drunk = false;
	double drunkPercent = 0.6;
	public DrunkenDriver() {
		vehicleC = Color.pink;
		size = 1;
		speed = 1;
	}

	public void move() {
		direction = direction(direction, speed);
		if (drunk) {
			direction = rand.nextInt(3);
		}
		switch (hitWall()) {
		case "Null":
			if (direction == 1) {
				position.translate(speed,0);
				// DIVERSERION FOR BILEN - SÅ DEN KAN RYKKE HØJRE OG VENSTRE!
				if (Math.random() < drunkPercent) {
					drunk = true;
				} else {
					drunk = false;
				}
			} else if (direction == 0) {
				position.translate(0,speed);
				if (Math.random() < drunkPercent) {
					drunk = true;
				} else {
					drunk = false;
				}
			} else if (direction == 3) {
				position.translate(-speed,0);
				if (Math.random() < drunkPercent) {
					drunk = true;
				} else {
					drunk = false;
				}
			} else if (direction == 2) {
				position.translate(0,-speed);
				if (Math.random() < drunkPercent) {
					drunk = true;
				} else {
					drunk = false;
				}
			}
			break;
		case "Right":
			position.translate(0,speed);
			direction = 0;
			break;
		case "Top":
			position.translate(-speed,0);
			direction = 3;
			break;
		case "Left":
			position.translate(0,-speed);
			direction = 2;
			break;
		case "Bottom":
			position.translate(speed,0);
			direction = 1;
			break;
		}
	}
	public String hitWall() {
		if (direction == 1) {
			if (position.getX() + calcSpeed() > Simulation.TRACKSIZE - size) {
				return "Right";
			}
		} else if (direction == 0) {
			if (position.getY() + calcSpeed() > Simulation.TRACKSIZE - size) {
				return "Top";
			}
		} else if (direction == 3) {
			if (position.getX() - calcSpeed() < 0 + size) {
				return "Left";
			}
		} else if (direction == 2) {
			if (position.getY() - calcSpeed() < 0 + size) {
				return "Bottom";
			}
		}
		return "Null";
	}
	public int calcSpeed() {
		return 1;
	}

	public Color getColor() {
		return vehicleC;
	}
}