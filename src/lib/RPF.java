package lib;

import java.util.ArrayList;
import java.util.List;

import lib.Fraction;
import lib.Maths;

public class RPF {
	
	public static String solve(int... a){
		if(a.length <= 2){
			return "ERROR: 3 or more parameters must be entered.";
		}
		String ans = "";
		int n = a.length;
		List<Integer> fp = (ArrayList<Integer>) factors(Math.abs(a[n-1])); // factors of a0
		List<Integer> fq = (ArrayList<Integer>) factors(Math.abs(a[0]));	// factors of an
		List<Fraction> poq = (ArrayList<Fraction>) getPOverQ(fp, fq);
		
		Fraction[] fa = new Fraction[a.length];
		for(int i = 0; i<fa.length; i++){
			fa[i] = new Fraction(a[i]);
		}
		
		ans = _solve(poq, fa);
				
		return ans;
	}
	
	private static String _solve(List<Fraction> poq, Fraction[] fa){
		String ans = "";
		boolean solved = false;
		
		for(Fraction f : poq){
			if(isMonomialFactor(f, fa)){
				ans += "(x "+ (f.isPositive() ? ("- "+f.value()) : ("+ "+f.mult(new Fraction(-1,1)).value())) + ") ";
				fa = polynomialDivision(f, fa).toArray( new Fraction[fa.length-1] );
				solved = true;
				break;
			}
		}
		if(!solved){
			int fac = (int) fa[0].value();
			for(int i = 0; i < fa.length; i++){
				fac = Maths.GCF(fac, (int)fa[i].value());
			}
			if(fac != 1){
				for(int i = 0; i<fa.length; i++){
					fa[i] = fa[i].divide(new Fraction(fac));
				}
				return ans + fac + _solve(poq, fa);
			}
			ans += "( ";
			for(int i = 0; i<fa.length; i++){
				ans += (fa[i].isPositive() ? ("+ "+fa[i].value()) : ("- "+fa[i].value()*-1))+
						((fa.length-i-1 != 0) ? ("x^"+(fa.length-i-1)) : "") + " ";
			}
			ans += " )";
			return ans;
		}
		if(fa.length <= 2){
			int fac = (int) fa[0].value();
			for(int i = 0; i < fa.length; i++){
				fac = Maths.GCF(fac, (int)fa[i].value());
			}
			if(fac != 1){
				ans += fac;
				fa[0] = fa[0].divide(new Fraction(fac));
				fa[1] = fa[1].divide(new Fraction(fac));
			}
			return ans + "("+fa[0].value()+"x + "+fa[1].value()+")";
		}
		return ans + _solve(poq, fa);
	}
	
	public static List<Integer> factors(int f) {
        int inc = 1;
        if (f % 2 != 0)	inc = 2;
        List<Integer> li = new ArrayList<Integer>();
        for (int i = 1; i <= Math.ceil( Math.sqrt(f) ); i=i+inc) {
            if (f % i == 0) {
                li.add(i);
            }
        }
        li.add(f);
        return li;
    }
	
	public static List<Fraction> getPOverQ(List<Integer> fp, List<Integer> fq){
		List<Fraction> poq = new ArrayList<Fraction>();
		// pos. & neg.
		for(Integer i : fp){
			for(Integer j : fq){
				poq.add( new Fraction(i,j) );
				poq.add( new Fraction(-i,j) );
			}
		}
		
		return poq;
	}
	
	public static boolean isMonomialFactor(Fraction f, Fraction[] coeff){		
		Fraction temp = f.mult(coeff[0]);
		for(int i = 1; i<coeff.length; i++){
			if(coeff[i].getNumerator()!=0)
				temp = temp.add(coeff[i]);
			if(i<coeff.length-1) temp = temp.mult(f);
		}
		return temp.equals(Fraction.ZERO);
	}
	
	public static List<Fraction> polynomialDivision(Fraction f, Fraction[] coeff){
		List<Fraction> rem = new ArrayList<Fraction>();
		
		Fraction temp = f.mult(coeff[0]);
		rem.add(coeff[0]);
		for(int i = 1; i<coeff.length; i++){
			if(coeff[i].getNumerator()!=0)
				temp = temp.add(coeff[i]);
			rem.add(temp);
			if(i<coeff.length-1) temp = temp.mult(f);
		}
		if(rem.get(rem.size()-1).equals(Fraction.ZERO)){
			rem.remove(rem.size()-1);
		}
		
		return rem;
	}
	
}
