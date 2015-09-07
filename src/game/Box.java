package game;

import lib.Geometry;

@SuppressWarnings("unused")
public class Box {
	
	private int x,y;
	private int width, height;
	private int centerX, centerY;
	
	public Box(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		setCenter();
	}
	
	public Box(){
		this(0,0,1,1);
	}
	
	public Box(int width, int height){
		this(0,0,width,height);
	}
	
	public Box(Box b){
		this(b.x,b.y,b.width,b.height);
	}
	
	private void setCenter(){
		centerX = x - width/2;
		centerY = y - height/2;
	}
	
	public boolean collided(Box b){
		
		// Vertical check
		if( ((b.x >= x) && (b.x <= x+width)) || ((b.x+b.width >= x) && (b.x+b.width <= x+width)) ){
			// Horizontal Check
			if( ((b.y <= y) && (b.y >= y+height)) || ((b.y-b.height <= y) && (b.y-b.height >= y+height)) ){
				return true;
			}
		}
		
		return false;
	}
	
	public boolean collided(Circle c){
		return Geometry.isPointInRectangle(c.getCenterX(), c.getCenterY(), width, height, x, y);
	}

}
