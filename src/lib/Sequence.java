package lib;

public class Sequence {
	
	private Sequence(){
		
	}
	
	public static double sum(int start, int end, SequenceModifier sm){
		double sum = 0;
		for(int i=start; i<=end; i++){
			sum += sm.sequenceModifier(i);
		}
		return sum;
	}
	
}
