package assignment_3.Exercise_2;

import java.awt.Color;
import java.awt.Point;

public class Vehicle {
	
	protected static Point position;
	protected static Color color;
	protected static int size;
	
	
	public Vehicle(Point position){
		this.position = getPosition();
	}
	
	public void setLocation(Point position){
		
	}
	
	public Point getPosition(){
		return position.getLocation();
	}
	
	public Color getColor(){
		return this.getColor();
	}
	
	public int getSize(){
		return this.getSize();
	}
}
