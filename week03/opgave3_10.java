package week03;

public class opgave3_10 {

	public static void main(String[] args) {
		
		System.out.println(binomial(10,7));
		
	}
	
	public static int binomial(int n, int k){
		
		int nk = (factorial(n))/
				 ((factorial(k))*(factorial(n-k)));
		
		return nk;
		
	}
	
	public static int factorial(int n){
		
		int factor = 1;
		
		for(int i = 1; i <= n ; i++ ){
			factor = factor * i;
		}
		
		return factor;
	}
	
}
