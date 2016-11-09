package week03;

import java.util.Scanner;

/*
Remark: When you use CodeJudge, class and method names have to be
precisely as shown above and you have to remove the package
declaration before uploading.

In this case class has to be named "Factorial" 
and the method "public static int factorial(int n)"
*/

public class opgave3_4 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	    System.out.println("Input value to factor");
        int number = scanner.nextInt();
        System.out.println(factorial(number));
        scanner.close();
		
	}
	
	public static int factorial(int n){
		
		int factor = 1;
		
		for(int i = 1; i <= n ; i++ ){
			factor = factor * i;
		}
		
		return factor;
	}
}
