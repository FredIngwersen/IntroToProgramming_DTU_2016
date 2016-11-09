package week02;

/* Print the first 12 Fibonacci numbers:
 * 1 1 2 3 5 8 13 21 34 55 89 144*/

// Second part requires one to print the first 50 numbers.

public class opgave2_4 {
	
	public static void main(String[] args){
		
		long a = 0;
		long b = 1;
		int number = 49; // <-- This can be changed to determine how many numbers are printed.
		
		System.out.print(1 + " ");
		
		for(int i = 1; i <= number; i++){
			long c = a+b;
			a=b;
			b= c;
			System.out.print(c + " ");
		}
	}
}
