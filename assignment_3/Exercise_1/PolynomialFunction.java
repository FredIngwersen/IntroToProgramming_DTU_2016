package assignment_3.Exercise_1;

public class PolynomialFunction extends Function {

	double[] a;
	
	public PolynomialFunction(double[] a){
		this.a = a;
	}
	
	public double evaluate(double x){
		int n = a.length;
		int sum = 0;
		
		for (int i = 0 ; i < n ; i++){
			sum+=Math.pow(a[i]*x, i);
		}
		return sum;
	}
}
