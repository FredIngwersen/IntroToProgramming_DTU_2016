package assignment_3.Exercise_2;

import java.awt.Color;
import java.awt.Point;

public class Bus extends Vehicle{

	private Color color;
	private int size;
	
	public Bus() {
		super(position);
	}
	
	public void setColor(Color color){
		this.color = Color.RED;
	}
	
	public Color getColor(){
		return this.color;
	}
	
	public void setSize(int size){
		this.size = 4;
	}
	
	public int getSize(){
		return this.size;
	}

}
