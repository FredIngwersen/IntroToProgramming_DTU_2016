package week04;

import java.util.Scanner;

public class opgave4_4 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	    System.out.print("Input a number:");
        String test = scanner.nextLine();
        
        isNumeric(test);

	}
	
	public static void isNumeric(String str){
		
		if(str.matches("-?\\d+(\\.\\d+)?")){
			System.out.println("Yes");
		} else {
			System.out.println("This is no number");
		}
	}

}
