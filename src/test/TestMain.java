package test;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Random;
import java.util.Scanner;

import lib.Maths;
import lib.Stopwatch;
import lib.TimerListener;

@SuppressWarnings("unused")
public class TestMain {
		
	static Scanner keybd = new Scanner(System.in);

	public static void main(String[] args) throws IOException{
		Stopwatch sw = new Stopwatch();
		sw.addTimerListener(new TimerListener(){
			public void startAction(long dt) {
				System.out.println("Timer Started\n");
			}
			public void stopAction(long dt) {
				System.out.println("\nTimer Stopped");
			}
			public void resetAction(long dt) {
				System.out.println("Timer Reset");
			}
		});
		sw.start();
		
		long a = 5L, b = 7L;
		
		Maths.printOperators(a, b);
		
		sw.stop();
		System.out.println("\nProgram took "+NumberFormat.getInstance().format(sw.getDeltaTime())+" nano second(s) to run or "+sw.toSeconds()+" seconds to run.");
	}
	
	private static String input(Scanner s, String message){
		System.out.print("Input ("+message+"): ");
		String input = s.nextLine();
		return input;
	}
	private static String input(Scanner s){
		return input(s,"");
	}

}
