package assignment_3.Exercise_2;

import java.awt.*;

/**
 * Created by William Ben Embarek on 14/11/2016.
 */
public class DrunkenDriver extends Vehicle {
	Boolean drunk = true;
	double drunkPercent = 1;
	public DrunkenDriver() {
		vehicleC = Color.pink;
		size = 1;
		speed = 1;
		position = setValidPosition();


	}

	public void move() {
		direction = direction(direction, speed);
		if (drunk) {
			if (direction == 3){
				direction = 0;
			}
			else
			{
				direction = direction +1;
			}
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
			position.translate(-speed,-speed);
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
			if (position.getX() + calcSpeed() > Simulation.TRACKSIZE - (size+1)) {
				return "Right";
			}
		} else if (direction == 0) {
			if (position.getY() + calcSpeed() > Simulation.TRACKSIZE - (size+1)) {
				return "Top";
			}
		} else if (direction == 3) {
			if (position.getX() - calcSpeed() < (size+1)) {
				return "Left";
			}
		} else if (direction == 2) {
			if (position.getY() - calcSpeed() < (size+1)) {
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
	public Point setValidPosition(){

		int vSize = size;
		int tWidth = Simulation.TRACKWIDTH-1-(vSize*2);
		int tSize = Simulation.TRACKSIZE-(vSize*2);
		int randomInt = (int)(Math.random() * 100);

		if(randomInt <= 25){
			return new Point(((int)(Math.random() * tWidth))+vSize,
					((int)(Math.random() * tSize))+vSize);
		} else if(randomInt > 25 && randomInt <= 50){
			return new Point((int)(Math.random() * tSize)+vSize,
					((int)(Math.random() * tWidth))+vSize);
		} else if(randomInt > 50 && randomInt <= 75){
			return new Point(((int)(Math.random() * tWidth))+(2*Simulation.TRACKWIDTH)+vSize,
					((int)(Math.random() * tSize))+vSize);
		} else{
			return new Point(((int)(Math.random() * tSize))+vSize,
					((int)(Math.random() * tWidth))+(2*Simulation.TRACKWIDTH)+vSize);
		}
	}
	public int getSize(){return size;}
	public Point getPosition() {return position;}
}