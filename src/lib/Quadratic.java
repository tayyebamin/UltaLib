package lib;

public class Quadratic {
	
	private double a;
	private double b;
	private double c;
	
	public Quadratic(double a, double b, double c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public Quadratic(){
		this(1,0,0);
	}
	
	public double[] roots(){
		double num1 = -b + Math.sqrt(b*b-4*a*c);
		double num2 = -b - Math.sqrt(b*b-4*a*c);
		double den = 2*a;
		
		double[] ans = {num1/den,num2/den};
		return ans;
	}
	
	public boolean hasRealRoots(){
		return (b*b-4*a*c)>=0;
	} 
	
	public double[] Vertex(){
		double x = -b/(2*a);
		double y = a*x*x+b*x+c;
		return new double[] {x,y};
	}
	
	public double VertexX(){
		return -b/(2*a);
	}
	
	public double VertexY(){
		double x = -b/(2*a);
		return a*x*x+b*x+c;
	}
	
	public boolean opensUpward(){
		return a>0;
	}
	
	public int numberOfRoots(){
		if(b*b-4*a*c<0)return 0;
		else if(b*b-4*a*c==0)return 1;
		else return 2;
	}
	
	public double Yint(){
		return c;
	}
	
	public double getY(double x){
		return a*x*x+b*x+c;
	}
	
	public double[] getX(double y){
		double den = 2 * a;
		double num1 = Math.sqrt(4*a*y-4*a*c+b*b)+b;
		double num2 = Math.sqrt(4*a*y-4*a*c+b*b)-b;
		double[] ans = {num1/den, num2/den};
		return ans;
	}
	
}
