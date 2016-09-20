package week4;

import java.util.Scanner;

// This is exercise 4.1

public class GradeConverter {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	    System.out.print("Input your grade:");
        int grade = scanner.nextInt();
        
        System.out.println(convert13to7(grade));

	}
	
	public static int convert13to7(int grade){
		
		if(grade == 13 || grade == 11){
			grade = 12;
		} else if(grade == 10){
			grade = 10;
		} else if(grade == 9 || grade == 8){
			grade = 7;
		} else if(grade == 7){
			grade = 4;
		} else if(grade == 6){
			grade = 2;
		} else if(grade == 5 || grade == 3){
			grade = 0;
		} else if(grade == 0){
			grade = -3;
		} else
			throw new IllegalArgumentException("Not a grade!");
		
		return grade;
	}

}
