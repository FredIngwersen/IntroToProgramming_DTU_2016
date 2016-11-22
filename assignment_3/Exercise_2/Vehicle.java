package assignment_3.Exercise_2;

import java.awt.*;
import java.util.Random;

/**
 * Created by William Ben Embarek on 09/11/2016.
 */
public abstract class Vehicle {
	Random rand = new Random();
	Point position; // START POSITION
	Color vehicleC;
	int size;
	int direction;
	int speed;
	double turnChance = 0.1;
	public static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;

	public Vehicle() {
	}

	public abstract void move();
	public Point getPosition()
	{
		return position;
	}
	public Color getColor() {
		return vehicleC;
	}
	public int getSize() {
		return size;
	}
	public int direction(int d, int speed) {
		//F�RSTE REKTANGEL
		if (position.getX() <= Simulation.TRACKWIDTH + Simulation.INNERSIZE && position.getY() <= Simulation.TRACKWIDTH - size) {
			if (direction == RIGHT) {
				return RIGHT;
			} else {
				if (Math.random() < turnChance) {
					return RIGHT;
				} else if (position.getY() <= 0 + size) {
					return RIGHT;
				} else {
					return DOWN;
				}
			}
			//ANDEN REKTANGEL
		} else if (position.getX() >= Simulation.TRACKSIZE - (Simulation.TRACKWIDTH - size) &&
				position.getY() <= Simulation.TRACKWIDTH + Simulation.INNERSIZE) {
			if (direction == UP) {
				return UP;
			} else {
				if (Math.random() < turnChance) {
					return UP;
				} else if (position.getX() >= Simulation.TRACKSIZE - size) {
					return UP;
				} else {
					return RIGHT;
				}
			}
			//TREDJE REKTANGEL
		} else if (position.getX() >= Simulation.TRACKWIDTH &&
				position.getY() >= Simulation.TRACKSIZE - (Simulation.TRACKWIDTH - size)) {
			if (direction == LEFT) {
				return LEFT;
			} else {
				if (Math.random() < turnChance) {
					return LEFT;
				} else if (position.getY() >= Simulation.TRACKSIZE - size) {
					return LEFT;
				} else {
					return UP;
				}
			}
			//FJERDE REKTANGEL
		} else if(position.getX() <= Simulation.TRACKWIDTH - size &&
				position.getY() >= Simulation.TRACKWIDTH) {
			if (direction == DOWN) {
				return DOWN;
			} else {
				if (Math.random() < turnChance) {
					return DOWN;
				} else if (position.getX() <= 0 + size) {
					return DOWN;
				} else {
					return LEFT;
				}
			}
		}
		return d;
	}
	// Starts the vehicle at a random valid location
	// Starts the vehicle at a random valid location



}



