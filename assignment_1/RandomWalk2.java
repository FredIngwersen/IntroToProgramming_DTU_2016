package assignment_1;

import java.util.Random;

public class RandomWalk2 {

	public static void main(String[] args) {
		
		runSimulation2(100, 4, 2);
	}
	
	public static void runSimulation2(int n, int t, int s){
		
		Random grid = new Random();
		int pointX_1 = grid.nextInt(n);
		int pointY_1 = grid.nextInt(n);
		
		int pointX_2 = grid.nextInt(n);
		int pointY_2 = grid.nextInt(n);
		
		int moveParticle_1 = 0;
		int moveParticle_2 = 0;
		
		System.out.println("n=" + n + " t=" + t + " s=" + s);
		System.out.printf("[%d;%d]  [%d;%d]\n",
						  pointX_1, pointY_1, pointX_2, pointY_2 );
		
		
		for(int i = 0; i <= t; i++){
			// Determine which point has the farthest to Particle1's corresponding point,
			// and then add or subtract s, depending on what will change Particle2's point
			// to be closer to the corresponding Particle1 point.
			int diffX = Math.abs(pointX_1 - pointX_2);
			int diffY = Math.abs(pointY_1 - pointY_2);
			
			if(diffX > diffY){
				if(pointX_1 > pointX_2){
					pointX_2 += s;
				} else {
					pointX_2 -= s;
				}
			} else if(pointY_1 > pointY_2){
				pointY_2 += s;
			} else {
				pointY_2 -= s;
			}
		
			moveParticle_1 = grid.nextInt(s+1) * (grid.nextBoolean() ? 1 : -1);
	
			if(randomBool()){
				if(moveParticle_1 + pointX_1 >= 0 && moveParticle_1 + pointX_1 < n){
					pointX_1 += moveParticle_1;
			} else if(moveParticle_1 + pointY_1 >= 0 && moveParticle_1 + pointY_1 < n)
				pointY_1 += moveParticle_1;
				
			}
			System.out.printf("[%d;%d]  [%d;%d]\n",
					  pointX_1, pointY_1, pointX_2, pointY_2 );
			if(pointX_1 == pointX_2 && pointY_1 == pointY_2){
				System.out.println("Crash");
				break;
			}
		}
	}
	
	public static boolean randomBool(){
		return Math.random() < 0.5;
	}
}
