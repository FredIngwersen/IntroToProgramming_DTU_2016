package assignment_3.Exercise_2;

import java.awt.Point;
import java.awt.Color;

public class Truck extends Vehicle{

	private Color color;
	private int size;
	
	public Truck() {
		super(position);
	}
	
	public void setColor(Color color){
		this.color = Color.BLACK;
	}
	
	public Color getColor(){
		return this.color;
	}
	
	public void setSize(int size){
		this.size = 5;
	}
	
	public int getSize(){
		return this.size;
	}


}
