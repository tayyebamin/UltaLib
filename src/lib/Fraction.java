package lib;

public class Fraction {
	
	public static Fraction ONE = new Fraction(1,1);
	public static Fraction ZERO = new Fraction(0,1);
	public static Fraction HALF = new Fraction(1,2);
	
	int num;
	int den;
	
	public Fraction(){
		this(1,1);
	}
	
	public Fraction(int num, int den){
		this.num = num;
		this.den = den;
	}
	
	public Fraction(double x){
		int[] r = Maths.toFraction(x);
		num = r[0];
		den = r[1];
	}
	
	public Fraction(String s){
		if(!s.contains("/")){
			s += "/1";
		}
		String[] sa = s.split("/");
		num = Integer.parseInt(sa[0]);
		den = Integer.parseInt(sa[1]);
	}
	
	public void reduce(){
		int[] r = Maths.reduceFraction(num, den);
		num = r[0];
		den = r[1];
	}
	
	public Fraction getReduced(){
		int[] ia = Maths.reduceFraction(num, den);
		return new Fraction(ia[0], ia[1]);
	}
	
	public double value(){
		return (double)num/(double)den;
	}
	
	public int getNumerator(){
		return num;
	}
	
	public int getDenominator(){
		return den;
	}
	 @Override
	public boolean equals(Object o){
		if(!(o instanceof Fraction)){
			return false;
		}
		if(this == o){
			return true;
		}
		return num * ((Fraction)o).getDenominator() == den * ((Fraction)o).getNumerator();
	}
	 @Override
	 public int hashCode(){
		 int hash = 3;
		 hash = 7 * hash + this.getReduced().num;
		 hash = 7 * hash + this.getReduced().den;
		 return hash;
	 }
	
	public Fraction mult(Fraction f){
		return new Fraction(num*f.getNumerator(), den*f.getDenominator());
	}
	
	public Fraction divide(Fraction f){
		return new Fraction(num*f.getDenominator(), den*f.getNumerator());
	}
	
	public Fraction mod(Fraction f){
		return new Fraction(value() % f.value());
	}
	
	public Fraction add(Fraction f){
		int lcm = Maths.LCM(den, f.getDenominator());
		return new Fraction((num*(lcm/den))+(f.getNumerator()*(lcm/f.getDenominator())), lcm);
	}
	
	public Fraction subtract(Fraction f){
		int lcm = Maths.LCM(den, f.getDenominator());
		return new Fraction((num*(lcm/den))-(f.getNumerator()*(lcm/f.getDenominator())), lcm);
	}
	
	public Fraction reciprocal(){
		return new Fraction(den, num);
	}
	
	public boolean isNegative(){
		return num < 0 ^ den < 0;
	}
	
	public boolean isPositive(){
		return (num > 0 && den > 0) || (num < 0 && den < 0);
	}
	
	@Override
	public String toString(){
		return num+"/"+den;
	}

	public static String operatorData(Fraction f1, Fraction f2){
		String s = "Fraction #1 == "+f1+"\n"+
				   "\tValue == "+f1.value()+"\n"+
				   "Fraction #2 == "+f2+"\n"+
				   "\tValue == "+f2.value()+"\n\n"+
				   f1+" + "+f2+" == "+f1.add(f2)+" or "+f1.add(f2).value()+"\n"+
				   f2+" + "+f1+" == "+f2.add(f1)+" or "+f2.add(f1).value()+"\n"+
				   f1+" - "+f2+" == "+f1.subtract(f2)+" or "+f1.subtract(f2).value()+"\n"+
				   f2+" - "+f1+" == "+f2.subtract(f1)+" or "+f2.subtract(f1).value()+"\n"+
				   f1+" * "+f2+" == "+f1.mult(f2)+" or "+f1.mult(f2).value()+"\n"+
				   f2+" * "+f1+" == "+f2.mult(f1)+" or "+f2.mult(f1).value()+"\n"+
				   f1+" / "+f2+" == "+f1.divide(f2)+" or "+f1.divide(f2).value()+"\n"+
				   f2+" / "+f1+" == "+f2.divide(f1)+" or "+f2.divide(f1).value();
		
		return s;
	}
}
