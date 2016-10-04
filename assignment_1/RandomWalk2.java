package assignment_1;

import java.util.Random;

public class RandomWalk2 {

	public static void main(String[] args) {
		
		runSimulation2(10, 4, 2);
	}
	
	public static void runSimulation2(int n, int t, int s){
		
		Random grid = new Random();
		
		int pointX_1 = grid.nextInt(n);	int pointY_1 = grid.nextInt(n);
		int pointX_2 = grid.nextInt(n);	int pointY_2 = grid.nextInt(n);
		
		int moveParticle_1 = 0;
		
		System.out.println("n=" + n + " t=" + t + " s=" + s);
		System.out.printf("[%d;%d] [%d;%d]\n",
						  pointX_1, pointY_1, pointX_2, pointY_2 );
		
		// Starting for loop to run for t moves
		for(int i = 1; i <= t; i++){
			// Determining which point (in Particle_2) that has the farthest
			// to Particle_1's corresponding point, and then adds or subtracts
			// s, depending on what will change Particle_2's point
			// to be closer to the corresponding Particle_1 point.
			int diffX = Math.abs(pointX_1 - pointX_2);
			int diffY = Math.abs(pointY_1 - pointY_2);
			
			// If x has the largest difference
			if(diffX > diffY){
				
				// If the difference is larger than or equal to s, move s
				if(diffX >= s){
					
					// Determines if x has to move negative or positive to get closer
					if(pointX_1 > pointX_2){
						pointX_2 += s;
					} else pointX_2 -= s;
					
				// If the difference is smaller than s, move the difference
				} else if(pointX_1 > pointX_2){
					pointX_2 += diffX;
				} else pointX_2 -= diffX;
				
			// If y has the largest difference
			} else if(diffY >= s){
				
				// Determines if y has to move negative or positive to get closer
				if(pointY_1 > pointY_2){
					pointY_2 += s;
				} else 	pointY_2 -= s;
				
			// If the difference is smaller than s, move the difference
			} else if(pointY_1 > pointY_2){
				pointY_2 += diffY;
			} else pointY_2 -= diffY;
				
			// Moves Particle1 just as in 1.2a
			moveParticle_1 = grid.nextInt(s+1) * (grid.nextBoolean() ? 1 : -1);
			if(randomBool()){
				if(moveParticle_1 + pointX_1 >= 0 && moveParticle_1 + pointX_1 < n){
					pointX_1 += moveParticle_1;
			} else if(moveParticle_1 + pointY_1 >= 0 && moveParticle_1 + pointY_1 < n)
				pointY_1 += moveParticle_1;
				
			}
			if(pointX_1 == pointX_2 && pointY_1 == pointY_2){
				System.out.printf("[%d;%d] [%d;%d]\n",
						  pointX_1, pointY_1, pointX_2, pointY_2 );
				System.out.println("Crash");
				break;
			}
			System.out.printf("[%d;%d] [%d;%d]\n",
					  pointX_1, pointY_1, pointX_2, pointY_2 );
		}
	}
	
	public static boolean randomBool(){
		return Math.random() < 0.5;
	}
}
