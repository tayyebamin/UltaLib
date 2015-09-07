package lib;

public class Trig {

	private Trig(){}
	
	public static double cos(double x) {
		return sin(x+(Math.PI/2.0));
	}
	
	public static double sec(double x){
		return 1.0/cos(x);
	}
	
	public static double csc(double x){
		return 1.0/sin(x);
	}
	
	public static double tan(double x){
		return sin(x)/cos(x);
	}
	
	public static double cot(double x){
		return cos(x)/sin(x);
	}
	
	public static double sin(double x) {
		x = x % (2 * Math.PI);

		double term = 1.0;
		double sum = 0.0;

		for (int i = 1; term != 0.0; i++) {
			term *= (x / i);
			if (i % 4 == 1)
				sum += term;
			if (i % 4 == 3)
				sum -= term;
		}

		return sum;
	}

}
