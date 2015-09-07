package lib;

public class Stringz {
	
	private Stringz(){}
	
	public static int words(String s){
		return s.split(" ").length;
	}
	
	public static int sentences(String s){
		return s.split(".").length;
	}
	
}
