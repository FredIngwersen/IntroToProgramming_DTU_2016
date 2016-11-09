package assignment_3.Exercise_1;

public class ExponentialFunction extends Function {

	double a; double b;
	
	public ExponentialFunction(double a, double b){
		this.a = a; this.b = b;
	}
	
	public double evaluate(double x){
		return a*Math.exp(b*x);
	}
}
