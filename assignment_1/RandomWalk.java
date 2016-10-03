package assignment_1;

import java.util.Random;
import java.math.*;

public class RandomWalk {

	public static void main(String[] args) {
		
		runSimulation(10, 50, 2);
		
	}

	public static void runSimulation(int n, int t, int s){
		
		Random grid = new Random();
		int pointX = grid.nextInt(n);
		int pointY = grid.nextInt(n);
		int move = 0;
		
		System.out.println("n=" + n + " t=" + t + " s=" + s);
		System.out.printf("[%d;%d]\n", pointX, pointY );
		
		for(int i = 0; i <= t; i++){
			
			// Moves are being determined with a random number 
			// (between 0 and s) and +/- at random
			move = grid.nextInt(s+1) * (grid.nextBoolean() ? 1 : -1);

			if(randomBool()){
				if(move + pointX >= 0 && move + pointX < n){
					pointX += move;
			} else if(move + pointY >= 0 && move + pointY < n)
				pointY += move;
				
			}
			System.out.printf("[%d;%d]\n", pointX, pointY );
		}
		
	}
	
	public static boolean randomBool(){
		return Math.random() < 0.5;
	}
}
