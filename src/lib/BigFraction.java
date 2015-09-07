package lib;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class BigFraction {

	BigInteger num;
	BigInteger den;

	public BigFraction() {
		this(BigInteger.ONE, BigInteger.ONE);
	}

	public BigFraction(BigInteger num, BigInteger den) {
		this.num = num;
		this.den = den;
	}

	public BigFraction(BigDecimal x) {
		BigInteger[] r = Maths.toFraction(x);
		num = r[0];
		den = r[1];
	}

	public void reduce() {
		BigInteger[] r = Maths.reduceFraction(num, den);
		num = r[0];
		den = r[1];
	}

	public BigFraction getReduced() {
		BigInteger[] r = Maths.reduceFraction(num, den);
		return new BigFraction(r[0], r[1]);
	}

	public BigDecimal value() {
		return new BigDecimal(num).divide(new BigDecimal(den), 32, RoundingMode.HALF_UP);
	}

	public BigInteger getNumerator() {
		return num;
	}

	public BigInteger getDenominator() {
		return den;
	}

	public BigFraction mult(BigFraction f) {
		return new BigFraction(num.multiply(f.getNumerator()), den.multiply(f
				.getDenominator()));
	}

	public BigFraction divide(BigFraction f) {
		return new BigFraction(num.multiply(f.getDenominator()), den.multiply(f
				.getNumerator()));
	}
	
	public BigFraction mod(BigFraction f) {
		return new BigFraction(num.multiply(f.getDenominator()), den.multiply(f
				.getDenominator()));
	}

	public BigFraction add(BigFraction f) {
		BigInteger lcm = Maths.LCM(den, f.getDenominator());
		return new BigFraction((num.multiply(lcm.divide(den))).add(f
				.getNumerator().multiply((lcm.divide(f.getDenominator())))),
				lcm);
	}

	public BigFraction subtract(BigFraction f) {
		BigInteger lcm = Maths.LCM(den, f.getDenominator());
		return new BigFraction((num.multiply(lcm.divide(den))).subtract(f
				.getNumerator().multiply((lcm.divide(f.getDenominator())))),
				lcm);
	}

	public BigFraction reciprocal() {
		return new BigFraction(den, num);
	}
	
	public void reciprocate(){
		BigInteger numTemp = num;
		BigInteger denTemp = den;
		num = denTemp;
		den = numTemp;
	}
	
	@Override
	public String toString(){
		return num+"/"+den;
	}
	
	public static String operatorData(BigFraction f1, BigFraction f2){
		String s = "BigFraction #1 == "+f1+"\n"+
				   "\tValue == "+f1.value()+"\n"+
				   "BigFraction #2 == "+f2+"\n"+
				   "\tValue == "+f2.value()+"\n\n"+
				   f1+" + "+f2+" == "+f1.add(f2)+" or "+f1.add(f2).value()+"\n"+
				   f2+" + "+f1+" == "+f2.add(f1)+" or "+f2.add(f1).value()+"\n"+
				   f1+" - "+f2+" == "+f1.subtract(f2)+" or "+f1.subtract(f2).value()+"\n"+
				   f2+" - "+f1+" == "+f2.subtract(f1)+" or "+f2.subtract(f1).value()+"\n"+
				   f1+" * "+f2+" == "+f1.mult(f2)+" or "+f1.mult(f2).value()+"\n"+
				   f2+" * "+f1+" == "+f2.mult(f1)+" or "+f2.mult(f1).value()+"\n"+
				   f1+" / "+f2+" == "+f1.divide(f2)+" or "+f1.divide(f2).value()+"\n"+
				   f2+" / "+f1+" == "+f2.divide(f1)+" or "+f2.divide(f1).value()+"\n"+
				   f1+" % "+f2+" == "+f1.mod(f2)+" or "+f1.mod(f2).value()+"\n"+
				   f2+" % "+f1+" == "+f2.mod(f1)+" or "+f2.mod(f1).value();
		
		return s;
	}

}
