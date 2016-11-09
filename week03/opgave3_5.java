package week03;
import java.math.*;
import java.util.Scanner;;

/*
Remark: When you use CodeJudge, class and method names have to be
precisely as shown above and you have to remove the package
declaration before uploading.

In this case class has to be named "Cosine" 
and the method "public static double cosine(double x, int k)"
*/

public class opgave3_5 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	    System.out.println("Input start value");
        double start = scanner.nextDouble();
	    System.out.println("Input end value");
        int end = scanner.nextInt();
        
        System.out.println(cosine(start, end));
        System.out.println(Math.cos(start));
        
	}

	public static double cosine(double x, int k){
		double res = 0;
		for(int i = 0; i<=k; i++){
			res+= ((Math.pow(-1, i))*Math.pow(x, 2*i))/(factorial(2*i));
		}
		
		
		return res;
	}
	
	public static int factorial(int n){
		
		int factor = 1;
		
		for(int i = 1; i <= n ; i++ ){
			factor = factor * i;
		}
		
		return factor;
	}
	
}
