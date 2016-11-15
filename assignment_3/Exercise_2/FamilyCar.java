package assignment_3.Exercise_2;

import java.awt.Color;
import java.awt.Point;

public class FamilyCar extends Vehicle{

	private Color color;
	private int size;
	
	public FamilyCar() {
		super(position);
	}
	
	public void setColor(Color color){
		this.color = Color.BLUE;
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
