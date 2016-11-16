import java.awt.*;

/**
 * Created by William Ben Embarek on 14/11/2016.
 */
public class Truck extends Vehicle{
	Point position = getPosition();
	public Truck() {
		vehicleC = Color.black;
		size = 3;
		speed = 1;


	}

	public void move() {
		switch (hitWall())
		{
		case "Null":
			direction = direction(direction, speed);
			if (direction == 1) {
				position.translate(speed,0);
			} else if (direction == 0) {
				position.translate(0,speed);
			} else if (direction == 3) {
				position.translate(-speed,0);
			} else if (direction == 2) {
				position.translate(0,-speed);
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
	public String hitWall()
	{
		if (direction == 1) {
			if (position.getX() + calcSpeed() > Simulation.TRACKSIZE - size)
			{
				return "Right";
			}
		} else if (direction == 0) {
			if (position.getY() + calcSpeed() > Simulation.TRACKSIZE - size)
			{
				return "Top";
			}
		} else if (direction == 3) {
			if (position.getX() - calcSpeed() < 0+size)
			{
				return "Left";
			}
		} else if (direction == 2) {
			if (position.getY() - calcSpeed() < 0+size)
			{
				return "Bottom";
			}
		}
		return "Null";
	}
	public int calcSpeed() {
		if (Math.random() < 0.3) {
			speed = 2;
		} else {
			speed = 1;
		}
		return speed;
	}
}