package week03;

import java.util.Scanner;

public class opgave3_3 {

	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		
		int num = console.nextInt();
		
		printNumbers(num);

	}
	
	public static void printNumbers(int number){
		
		for(int i = 1; i <= number; i++){
			System.out.print("["+i+"]");
		}
	}

}
