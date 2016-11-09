package week07;

import java.text.DecimalFormat;

public class Road {

// Declaring variables
	private double length, width;
	private String name, surface;


// Declaring allowed surfaces
	private static String[] allowed_surfaces = {
			"asphalt", "concrete", "gravel", "dirt"};

// Declaring my decimal formatting
	private static DecimalFormat df = new DecimalFormat("0.00");

// Setting the width, which is not allowed to be less than 1
	public double getWidth(){
		return width;
	}
	public void setWidth(double width){
		if(width >= 1.0){
			this.width = width;
		} else {
			System.out.println("No, this is not allowed.");
		}
	}

// Setting the surface, which has to be one of the allowed ones.
	public String getSurface(){
		return surface;
	}
	public void setSurface(String newSurface){

		if(surfaceAllowed(newSurface)){
			this.surface = newSurface;
		} else {
			System.out.println("No, this is not allowed.");
		}
	}

// One is not allowed to modify the length after declared.
	public double getLength(){
		return length;
	}
	public void setLength(double newLength){
		System.out.println("No, this is not allowed.");
	}

// Name will be set to "ILLEGAL" if other parameters are illegal
	public String getName(){
		return name;
	}
	public void setName(String newName){
		if(!name.equals("ILLEGAL")){
			this.name = newName;
		} else {
			System.out.println("No, this is not allowed.");
		}
	}


	public Road(double length, double width, String name, String surface){

		if(length > 0 && width >= 1 && surfaceAllowed(surface) && !name.equals("ILLEGAL")){
			this.length = length;
			this.width = width;
			this.name = name;
			this.surface = surface;
		} else {
			this.name = "ILLEGAL";
			this.length = 0.0;
			this.width = 0.0;
			this.surface = "";
		}
	}

// A method for checking if the surface is declared legally
	private boolean surfaceAllowed(String surface){
		boolean found = false;
		int i = 0;
		while(i < allowed_surfaces.length && !found){
			if(surface.equals(allowed_surfaces[i])){
				found = true;
			}
			i++;
		}
		return found;
	}
	
// Puts all the details into a string
	public String toString(){
		return "Road " + name + " l=" + df.format(length) + " w=" + 
				df.format(width) + " surface=" + surface;
	}
}
