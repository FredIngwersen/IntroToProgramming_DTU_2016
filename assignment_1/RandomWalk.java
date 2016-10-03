package assignment_1;

import java.util.Random;
import java.math.*;

public class RandomWalk {

	public static void main(String[] args) {
		
		runSimulation(5, 4, 2);
		
	}

	public static void runSimulation(int n, int t, int s){
		
		System.out.println("n=" + n + " t=" + t + " s=" + s);
		
		Random grid = new Random();
		int pointX = grid.nextInt(n);
		int pointY = grid.nextInt(n);
		
		System.out.println("x = " + pointX + " and y = " + pointY);
		
		for(int i = 0; i <= t; i++){
			
		}
	}
}
