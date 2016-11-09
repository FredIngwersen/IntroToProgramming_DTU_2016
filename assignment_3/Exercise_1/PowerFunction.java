package assignment_3.Exercise_1;

public class PowerFunction extends Function{

	double a;
	double b;
	
	public PowerFunction(double a, double b){
		this.a = a;
		this.b = b;
	}
	
	public double evaluate(double x){
		return (b*Math.pow(Math.abs(x), a));
	}
}
