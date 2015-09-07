package lib;

public class Stopwatch {
	
	long start;
	long stop;
	long dt;
	
	boolean doFire;
	TimerListener tl;
	
	public Stopwatch(){
		start = 0;
		stop = 0;
		dt = 0;
		doFire = false;
	}
	
	public Stopwatch(TimerListener tl){
		start = 0;
		stop = 0;
		dt = 0;
		doFire = true;
		this.tl = tl;
	}
	
	public void start(){
		start = System.nanoTime();
		if(doFire) tl.startAction(dt);
	}
	
	public void stop(){
		stop = System.nanoTime();
		dt = stop - start;
		if(doFire) tl.stopAction(dt);
	}
	
	public void reset(){
		start = 0;
		stop = 0;
		dt = 0;
		if(doFire) tl.resetAction(dt);
	}
	
	public double toSeconds(){
		return dt/1000000000d;
	}
	
	public long getDeltaTime(){
		return dt;
	}
	
	public void printDeltaTime(){
		System.out.println(dt);
	}
	
	public void addTimerListener(TimerListener tl){
		this.tl = tl;
		doFire = true;
	}
	
}
