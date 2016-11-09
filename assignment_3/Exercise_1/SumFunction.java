package assignment_3.Exercise_1;

public class SumFunction extends Function{

	Function[] f;
	
	public SumFunction(Function[] f){
		this.f = f;
	}
	
	public double evaluate(double x){
		int n = f.length;
		int sum = 0;
		
		for(int i = 0; i < n; i++){
			sum += f[i].evaluate(x);
		}
		
		return sum;
	}
}
