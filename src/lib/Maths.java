package lib;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class Maths {
		
	private Maths(){}
	
	public static int bitwiseMultiply(int n1, int n2) {
        int a = n1, b = n2, result=0;
        while (b != 0) {
            if ((b & 01) != 0) {
                result = result + a; 
            }
            a <<= 1;              
            b >>>= 1;             
        }
        return result;
	}

    public static int bitwiseAdd(int n1, int n2) {
        int x = n1, y = n2;
        int xor, and, temp;
        and = x & y;
        xor = x ^ y;

        while (and != 0) {
            and <<= 1;
            temp = xor ^ and;
            and &= xor;
            xor = temp;
        }
        return xor;
    }
    
    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
    
    public static double log(double base, double input){
    	return Math.log10(input)/Math.log10(base);
    }
    
    public static List<Integer> factors(int num){
        int incrementer = 1;
        if (num % 2 != 0)
        {
            incrementer = 2; //only test the odd ones
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= num / 2; i=i+incrementer)
        {
            if (num % i == 0)
            {
                list.add(i);
            }
        }
        list.add(num);
        return list;
    }
    
    public static int[] factorsArray(int num){
       return convertIntegers(factors(num));
    }
    
    private static int[] convertIntegers(List<Integer> integers){
        int[] ret = new int[integers.size()];
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = iterator.next().intValue();
        }
        return ret;
    }
    
    public static int GCF(int a, int b){
    	if (b==0) return a;
    	return GCF(b,a%b);
    }
    
    public static BigInteger GCF(BigInteger a, BigInteger b){
    	if(b.compareTo(BigInteger.ZERO) == 0) return a;
    	return GCF(b, a.mod(b));
    }
    
    public static int LCM(int a, int b){
    	return a * (b / GCF(a, b));
    }
    
    public static BigInteger LCM(BigInteger a, BigInteger b){
    	return a.multiply( b.divide(GCF(a,b)) );
    }
    
    public static int[] reduceFraction(int num, int den){
    	int gcf = GCF(num, den);
    	int[] rf = {num/gcf, den/gcf};
    	return rf;
    }
    
    public static BigInteger[] reduceFraction(BigInteger num, BigInteger den){
    	BigInteger gcf = GCF(num, den);
    	BigInteger[] rf = {num.divide(gcf), den.divide(gcf)};
    	return rf;
    }
    
    private static int[] toFractionPos(double x){
    	DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
    	df.setMaximumFractionDigits(340); // Maximum amount expected
    	String s = df.format(x);
    	if(!df.format(x).contains(".")){
    		s += ".0";
    	}
    	String[] parts = s.split("\\.");
    	double den = Math.pow(10, parts[1].length());
    	double num = Double.parseDouble(parts[0]) * den + Double.parseDouble(parts[1]);
    	return reduceFraction((int)num, (int)den);
    }
    
    private static BigInteger[] toFractionPos(BigDecimal x){
    	String[] parts = x.toString().split("\\.");
    	BigInteger den = BigInteger.TEN.pow(parts[1].length());
    	BigInteger num = (new BigInteger(parts[0]).multiply(den)).add(new BigInteger(parts[1]));
    	return reduceFraction(num, den);
    }
    
    public static int[] toFraction(String s){
    	return toFraction(Double.parseDouble(s));
    }
    
    public static int[] toFraction(double x){
    	int[] frac = new int[2];
    	if(x == 0){
    		frac[0] = 0;
    		frac[1] = 0;
    	}else if(x < 0){
    		frac = toFractionPos(-x);
    		frac[0] = -frac[0];
    	}else{
    		return toFractionPos(x);
    	}
    	return frac;
    }
    
    public static BigInteger[] toFraction(BigDecimal x){
    	BigInteger[] frac = new BigInteger[2];
    	if(x.compareTo(BigDecimal.ZERO) == 0){
    		frac[0] = BigInteger.ZERO;
    		frac[1] = BigInteger.ZERO;
    	}else if(x.compareTo(BigDecimal.ZERO) == -1){
    		frac = toFractionPos( x.multiply(BigDecimal.valueOf(-1)) );
    		frac[0] = frac[0].multiply( BigInteger.valueOf(-1) );
    	}else{
    		return toFractionPos(x);
    	}
    	return frac;
    }
    
    public static boolean isEqualFraction(int num1, int den1, int num2, int den2){
    	return (num1*den2) == (num2*den1);
    }
    
    public static double sum(double[] ary){
    	double sum = 0;
    	for(int i = 0; i < ary.length; i++){
    		sum += ary[i];
    	}
    	return sum;
    }
    
    public static long sum(long[] ary){
    	long sum = 0;
    	for(int i = 0; i < ary.length; i++){
    		sum += ary[i];
    	}
    	return sum;
    }
    
    public static double product(double[] ary){
    	double prod = 1.0D;
    	for(int i = 0; i < ary.length; i++){
    		prod *= ary[i];
    	}
    	return prod;
    }
    
    public static double quotient(double[] ary, boolean beginning){
    	double ratio;
    	if(beginning){
    		ratio = ary[0];
    		for(int i = 1; i < ary.length; i++){
    			ratio /= ary[i];
    		}
    	}else{
    		ratio = ary[ary.length-1];
    		for(int i = ary.length-2; i >= 0; i--){
    			ratio /= ary[i];
    		}
    	}
    	return ratio;
    }
    
    public static double quotient(double[] ary){
    	return quotient(ary, true);
    }
    
    public static double difference(double[] ary, boolean beginning){
    	double diff;
    	if(beginning){
    		diff = ary[0];
    		for(int i = 1; i < ary.length; i++){
    			diff -= ary[i];
    		}
    	}else{
    		diff = ary[ary.length-1];
    		for(int i = ary.length-2; i >= 0; i--){
    			diff -= ary[i];
    		}
    	}
    	return diff;
    }
    
    public static double difference(double[] ary){
    	return difference(ary, true);
    }
    
    public static long pow2(long pow){
    	return 1 << pow;
    }
    
    public static double average(double[] ary){
    	return sum(ary)/ary.length;
    }
    
    public static long average(long[] ary){
    	return sum(ary)/ary.length;
    }
    
    public static double median(double[] ary){
    	return ary[ary.length/2];
    }
    
    public static int numberOfGroups(double[] ary){
    	return factorial(ary.length);
    }
    
    public static boolean isEven(int x){
    	return x%2==0;
    }
    
    public static boolean isOdd(int x){
    	return x%2!=0;
    }
    
    public static double clamp(double min, double value, double max){
    	return value < min ? min : (value > max) ? max : value;
    }
    
    public static double min(double x, double y){
    	return x<y ? x : y;
    }
    
    public static double max(double x, double y){
    	return x>y ? x : y;
    }
    
    public static double[] toDoubleArray(List<Double> l){
    	double[] d = new double[l.size()];
    	for(int i = 0; i < l.size(); i++){
    		d[i] = l.get(i).doubleValue();
    	}
    	return d;
    }
    
    public static void printOperators(long x, long y){
    	System.out.println(x + " << " + y + " == " + (x<<y));
		System.out.println(x + " >> " + y + " == " + (x>>y));
		System.out.println(x + " >>> " + y + " == " + (x>>>y));
		System.out.println(x + " & " + y + " == " + (x&y));
		System.out.println(x + " | " + y + " == " + (x|y));
		System.out.println(x + " ^ " + y + " == " + (x^y));
		System.out.println(x + " + " + y + " == " + (x+y));
		System.out.println(x + " - " + y + " == " + (x-y));
		System.out.println(x + " * " + y + " == " + (x*y));
		if(y != 0){
			System.out.println(x + " / " + y + " == " + (x/y));
			System.out.println(x + " % " + y + " == " + (x%y));
		}
		System.out.println();
    }
    
    public static void printOperators(double x, double y){
//    	System.out.println(x + " << " + y + " == " + (x<<y));
//		System.out.println(x + " >> " + y + " == " + (x>>y));
//		System.out.println(x + " >>> " + y + " == " + (x>>>y));
//		System.out.println(x + " & " + y + " == " + (x&y));
//		System.out.println(x + " | " + y + " == " + (x|y));
//		System.out.println(x + " ^ " + y + " == " + (x^y));
		System.out.println(x + " + " + y + " == " + (x+y));
		System.out.println(x + " - " + y + " == " + (x-y));
		System.out.println(x + " * " + y + " == " + (x*y));
		if(y != 0){
			System.out.println(x + " / " + y + " == " + (x/y));
			System.out.println(x + " % " + y + " == " + (x%y));
		}
		System.out.println();
    }
}
