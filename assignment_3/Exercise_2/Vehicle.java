package assignment_3.Exercise_2;

import java.awt.*;
import java.util.Random;

/**
 * Created by William Ben Embarek on 09/11/2016.
 */
public abstract class Vehicle {
    Random rand = new Random();
    private Point position = setValidPosition(); // START POSITION
    Color vehicleC;
    double size;
    int direction;
    int speed;
    double turnChance = 0.1;

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

    public double getSize() {
        return size;
    }
    public int direction(int d, int speed) {
        if (position.getX() <= Simulation.TRACKWIDTH + Simulation.INNERSIZE && position.getY() <= Simulation.TRACKWIDTH - size) {
            if (direction == 1) {
                return 1;
            } else {
                if (Math.random() < turnChance) {
                    return 1;
                } else if (position.getY() <= 0 + size) {
                    return 1;
                } else {
                    return 2;
                }
            }
        } else if (position.getX() >= Simulation.TRACKSIZE - Simulation.TRACKWIDTH + size &&
                position.getY() <= Simulation.TRACKWIDTH + Simulation.INNERSIZE) {
            if (direction == 0) {
                return 0;
            } else {
                if (Math.random() < turnChance) {
                    return 0;
                } else if (position.getX() >= Simulation.TRACKSIZE - size) {
                    return 0;
                } else {
                    return 1;
                }
            }
        } else if (position.getX() >= Simulation.TRACKSIZE - (Simulation.TRACKWIDTH + Simulation.INNERSIZE) &&
                position.getY() >= Simulation.TRACKSIZE - Simulation.TRACKWIDTH + size) {
            if (direction == 3) {
                return 3;
            } else {
                if (Math.random() < turnChance) {
                    return 3;
                } else if (position.getY() >= Simulation.TRACKSIZE - size) {
                    return 3;
                } else {
                    return 0;
                }
            }
        } else if(position.getX() <= Simulation.TRACKWIDTH - size &&
                position.getY() >= Simulation.TRACKSIZE - (Simulation.TRACKWIDTH + Simulation.INNERSIZE) ) {
            if (direction == 2) {
                return 2;
            } else {
                if (Math.random() < turnChance) {
                    return 2;
                } else if (position.getX() <= 0 + size) {
                    return 2;
                } else {
                    return 3;
                }
            }
        }
        return d;
    }
    // S�TTER START POSITION TIL RANDOM
    public Point setValidPosition(){
   	 
    	int randomInt = (int)(Math.random() * 100);
    	
    	if(randomInt <= 25){
    		return new Point((int)(Math.random() * Simulation.TRACKWIDTH), (int)(Math.random() * (Simulation.TRACKSIZE)));
    	} else if(randomInt > 25 && randomInt <= 50){
    		return new Point((int)(Math.random() * (Simulation.TRACKSIZE)), (int)((Math.random() * (Simulation.TRACKWIDTH))+2*Simulation.TRACKWIDTH));
    	} else if(randomInt > 50 && randomInt <= 75){
    		return new Point((int)((Math.random() * (Simulation.TRACKSIZE))+2*Simulation.TRACKWIDTH), (int)(Math.random() * (Simulation.TRACKWIDTH)));
    	} else{
    		return new Point((int)(Math.random() * (Simulation.TRACKSIZE)), (int)(Math.random() * (Simulation.TRACKWIDTH)));
    	}
    }



}