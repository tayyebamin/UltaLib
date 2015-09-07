package lib;


public class Geometry {
	
	public static double SquarePerimeter(double side){
		return (4*side);
	}
	
	public static double SquareArea(double side){
		return side*side;
	}
	
	public static double RectPerimeter(double side1, double side2){
		return 2*side1+2*side2;
	}
	
	public static double RectArea(double side1, double side2){
		return side1*side2;
	}
	
	public static double CircleCircumference(double radius){
		return 2.0*radius*Math.PI;
	}
	
	public static double CircleArea(double radius){
		return Math.PI*radius*radius;
	}
	
	public static double TriangleAngle(double angle1, double angle2){
		return 180-(angle1+angle2);
	}
	
	public static double Hypotenuse(double sideA, double sideB){
		return Math.sqrt(sideA*sideA+sideB*sideB);
	}
	
	public static double TrianglePerimeter(double side1, double side2, double side3){
		return side1+side2+side3;
	}
	
	public static double TriangleArea(double base, double altitude){
		return 0.5*base*altitude;
	}
	
	public static double TriangleArea(double side1, double side2, double side3){
		double p = TrianglePerimeter(side1, side2, side3);
		return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
	}
	
	public static boolean isPointInRectangle(int px, int py, int width, int height, int rx, int ry){
		return (px > rx) && (px < rx+width) && (py > ry) && (py < ry+height);
	}
	
}
