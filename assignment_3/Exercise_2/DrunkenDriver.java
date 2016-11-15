package assignment_3.Exercise_2;

import java.awt.Color;
import java.awt.Point;

public class DrunkenDriver extends Vehicle{

	private Color color;
	private int size;
	
	public DrunkenDriver() {
		super(position);
	}
	
	public void setColor(Color color){
		this.color = Color.YELLOW;
	}
	
	public Color getColor(){
		return this.color;
	}
	
	public void setSize(int size){
		this.size = 3;
	}
	
	public int getSize(){
		return this.size;
	}

}
