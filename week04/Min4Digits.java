package week04;

import java.util.Scanner;

// This is exercise 4_2

public class Min4Digits {

	public static String number;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	    System.out.print("Input a number:");
        int number = scanner.nextInt();

        System.out.println(min4Digits(number));
	}
	
	public static String min4Digits(int n){
		
		
		if(n < -100 && n > -1000){
			n = Math.abs(n);
			number = "-0"+Integer.toString(n);
		} else if(n < -10 && n > -100){
			n = Math.abs(n);
			number = "-00"+Integer.toString(n);
		} else if(n < 0 && n > -10){
			n = Math.abs(n);
			number = "-000"+Integer.toString(n);
		} else if(n > 0 && n < 10){
			number = "000"+Integer.toString(n);
		} else if(n > 10 && n < 100){
			number = "00"+Integer.toString(n);
		} else if(n > 100 && n < 1000){
			number = "0"+Integer.toString(n);
		} else {
			number = Integer.toString(n);
		}
		
		return number;
	}

}
