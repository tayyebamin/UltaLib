package game;

public class Circle {
	
	private int x, y;
	private int centerX, centerY;
	private int radius, diameter;
	
	public Circle(){
		this(0,0,1);
	}
	
	public Circle(int radius){
		this(0,0,radius);
	}
	
	public Circle(int x, int y){
		this(x,y,1);
	}
	
	public Circle(int x, int y, int radius){
		this.x = x;
		this.y = y;
		this.radius = radius;
		diameter = radius*2;
		setCenter();
	}
	
	public Circle(Circle c){
		this(c.x,c.y,c.radius);
	}
	
	private void setCenter(){
		centerX = x - radius;
		centerY = y - radius;
	}
	
	public int getX(){
		return x;
	}
	public void setX(int x){
		this.x = x;
		setCenter();
	}
	
	public int getY(){
		return y;
	}
	public void setY(int y){
		this.y = y;
		setCenter();
	}
	
	public int getCenterX(){
		return centerX;
	}
	public int getCenterY(){
		return centerY;
	}
	
	public int getRadius(){
		return radius;
	}
	public void setRadius(int r){
		this.radius = r;
		setCenter();
	}
	
	public int getDiameter(){
		return diameter;
	}
	
	public boolean collided(Circle c){
		double dist = Math.sqrt( (centerX - c.centerX)*(centerX-c.centerX) + (centerY-c.centerY)*(centerY-c.centerY) );// sqrt( (x1 - x2)^2 + (y1 - y2)^2 )
		return dist <= radius + c.radius;
	}

}
