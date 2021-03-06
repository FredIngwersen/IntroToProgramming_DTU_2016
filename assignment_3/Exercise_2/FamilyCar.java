package assignment_3.Exercise_2;

import java.awt.*;

/**
 * Created by William Ben Embarek on 14/11/2016.
 */
public class FamilyCar extends Vehicle{
	public FamilyCar() {
		vehicleC = Color.blue;
		size = 1;
		speed = 1;
		position = setValidPosition();

	}

	public void move() {
		switch (hitWall())
		{
		case "Null":
			direction = direction(direction, speed);
			if (direction == 1) {
				position.translate(speed,0);
				// DIVERSERION FOR BILEN - S� DEN KAN RYKKE H�JRE OG VENSTRE!
				if (Math.random() < 0.3) {
					if (Math.random() < 0.3) {
						if (position.getY() < Simulation.TRACKWIDTH - size) {   
							position.translate(0,1);
						}
					} else if (Math.random() < 0.3) {
						if (position.getY() > 0 + size) {   
							position.translate(0,-1);
						}
					}

				}
			} else if (direction == 0) {
				position.translate(0,speed);
				if (Math.random() < 0.3) {
					if (Math.random() < 0.3) {
						if (position.getX() < Simulation.TRACKSIZE - size) {
							position.translate(1,0);
						}
					} else if (Math.random() < 0.3) {
						if (position.getX() > Simulation.INNERSIZE + Simulation.TRACKWIDTH + size) {
							position.translate(-1,0);
						}
					}
				}
			} else if (direction == 3) {
				position.translate(-speed,0);
				if (Math.random() < 0.3) {
					if (Math.random() < 0.3) {
						if (position.getY() <  Simulation.TRACKSIZE - size) { 
							position.translate(0,1);
						}
					} else if (Math.random() < 0.3) {
						if (position.getY() > Simulation.INNERSIZE + Simulation.TRACKWIDTH + size) {
							position.translate(0,-1);
						}
					}
				}
			} else if (direction == 2) {
				position.translate(0,-speed);
				if (Math.random() < 0.3) {
					if (Math.random() < 0.3) {
						if (position.getX() < Simulation.TRACKWIDTH - size) {
							position.translate(1,0);
						}
					} else if (Math.random() < 0.3) {
						if (position.getX() > 0 + size) {
							position.translate(-1,0);
						}
					}
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
            if (position.getX() + speed > Simulation.TRACKSIZE - (size+1)) {
                return "Right";
            }
        } else if (direction == 0) {
            if (position.getY() + speed > Simulation.TRACKSIZE - (size+1)) {
                return "Top";
            }
        } else if (direction == 3) {
            if (position.getX() - speed < (size+1)) {
                return "Left";
            }
        } else if (direction == 2) {
            if (position.getY() - speed < (size+1)) {
                return "Bottom";
            }
        }
		return "Null";
	}
	public int calcSpeed() {
		if (Math.random() < 0.3) {
			speed = 4;
		} else if (Math.random() < 0.3) {
			speed = 3;
		} else {
			speed = 2;
		}
		return speed;
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

	public Color getColor() {
		return vehicleC;
	}
}