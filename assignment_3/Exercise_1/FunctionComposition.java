package assignment_3.Exercise_1;

public class FunctionComposition extends Function{
	Function[] f;

	public FunctionComposition(Function[] f){
		this.f = f;
	}

	public double evaluate(double x){
		int n = f.length-1;
		
		double sum = f[n].evaluate(x);
			
		n -= 1;
		
		for (int i = n; i >= 0; i--){
			
			sum = f[i].evaluate(sum);	
			System.out.println("n = " + i + "________ sum = " + sum);
		}
		return sum;
	}
}
