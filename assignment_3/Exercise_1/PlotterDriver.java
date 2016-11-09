package assignment_3.Exercise_1;

public class PlotterDriver {

	public static void main(String[] args) {
		Function f1 = new SineFunction(0.8, 2.1);
		Function f2 = new PowerFunction(2, 2.1);
		Function f3 = new ExponentialFunction(3.2, 1.3);
		double[] a = {-3.1, 4.1,-2.1,0.4};
		Function f4 = new PolynomialFunction(a);
		double[] satan = {1.0, 0, -0.1666666667, 0, 0.008333333333, 0, -0.0001984126984,
				0, 0.000002755731922, 0, -0.00000002505210839, 0, 0.0000000001605904384,
				0, -7.647163732*Math.pow(10, -13), 0, 2.811457254*Math.pow(10, -15), 0,
				-8.220635247*Math.pow(10, -18)};
		Function f5 = new PolynomialFunction(satan);
		Function[] f = {f1,f2,f3,f4,f5};
		Function f6 = new SumFunction(f);
		Function[] Goathead = {f4, f1, f3, f5, f2};
		Function f7 = new FunctionComposition(Goathead);
		
		FunctionPlotter fup = new FunctionPlotter();
		fup.plotGraph(f7, -10, 10, 500);
	}

}
