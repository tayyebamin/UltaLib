package lib;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Utilities {
	
	private Utilities(){}
	
	public static Dimension getScreenSize(){
		return Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	public static int getScreenWidth(){
		return getScreenSize().width;
	}
	
	public static int getScreenHeight(){
		return getScreenSize().height;
	}
	
	public static int getScreenResolution(){
		return Toolkit.getDefaultToolkit().getScreenResolution();
	}
	
}
