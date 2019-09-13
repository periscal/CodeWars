package CodeWars;
/**
 * Numberless Number Representation
You're facing some restrictions in your implementation too: 
you can't use any fields or parameters that aren't of type
 NaturalNumber (except in Object#equals(Object)) and you can't 
 define any classes other than NaturalNumber. Otherwise, this 
 problem would be entirely trivial.

You can assume none of the tests will ever produce a negative
 number; you'll only have to work on the domain of positive numbers.
  You can also assume the numbers in tests will be reasonably small; 
  you won't have to deal with any numbers greater than 100.

 * @author jperiscal
 *
 */

public class NaturalNumber {

	public static final NaturalNumber ZERO = new NaturalNumber();

	public NaturalNumber predecesor=null;
	public NaturalNumber sucesor=null;

	public NaturalNumber succ() {
		if(sucesor == null) {
			NaturalNumber num = new NaturalNumber();
			this.sucesor = num;
			num.predecesor = this;
		}
		return sucesor;
	}

	public NaturalNumber pred() {
		if(predecesor == null) {
			NaturalNumber num = new NaturalNumber();
			this.predecesor = num;
			num.sucesor = this;
		}
		return predecesor;
	}

	public NaturalNumber add(NaturalNumber o) {
		NaturalNumber num =this;

		for(int i = 0; i<o.resolve(); i++) {
			if(sucesor == null) {
				NaturalNumber suc = new NaturalNumber();
				num.sucesor = suc;
				suc.predecesor = num;
			}
			num = num.succ();
		}
		return num;
	}

	public NaturalNumber subtract(NaturalNumber o) {
		NaturalNumber num =this;

		for(int i = 0; i<o.resolve(); i++) {
			/*if(sucesor == null) {
				NaturalNumber suc = new NaturalNumber();
				num.sucesor = suc;
				suc.predecesor = num;
			}*/
			num = num.pred();
		}
		return num;
	}

	public NaturalNumber multiply(NaturalNumber o) {
		NaturalNumber num =this;

		int mult1= this.resolve();
		int mult2 = o.resolve();

		int resultado = mult1*mult2;
		if(resultado == 0) return NaturalNumber.ZERO;
		for(int i = mult1; i<resultado ; i++) num = num.succ();
		
		return num;
	}

	public NaturalNumber modulo(NaturalNumber o) {
		

		int numero= this.resolve();
		int divisor = o.resolve();

		int resultado = numero%divisor;
		
		if(resultado == 0) return NaturalNumber.ZERO;
		
		NaturalNumber num = NaturalNumber.ZERO;
		for(int i = 0; i<resultado; i++) num = num.succ();

		return num;
	}

	public int resolve() {
		int entero=1;
		
		NaturalNumber num = this.pred();
		
		if(this == NaturalNumber.ZERO) return 0;
		while(num!= null && num!= NaturalNumber.ZERO) {
			entero++;
			num = num.pred();
		}
		return entero;
	}

	public boolean equals(Object o) {
		return this.resolve() == ((NaturalNumber)o).resolve();
	}
}
