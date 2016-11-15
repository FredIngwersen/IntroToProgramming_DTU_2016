package assignment_3.Exercise_1;

public class PolynomialFunction extends Function {

	double[] a;
	
	public PolynomialFunction(double[] a){
		this.a = a;
	}
	
	public double evaluate(double x){
		int n = a.length;
		double sum = 0;
		
		for (int i = 0 ; i < n ; i++){
			sum = sum + (a[i] * Math.pow(x, i));
		}
		return sum;
	}
}
