public class RatNum {

	public static int gcd(int m, int n) {
		
		if (m == 0 && n == 0) {
			throw new IllegalArgumentException();
		}
		if (m < 0) {
			m = m * -1;
		}
		if (n < 0) {
			n = n * -1;
		}		
		if (m == 0 || n == 0) {
			return m + n;
		}
		int r = m%n;
		while ( r != 0 ) {
			m = n;
			n = r;
			r = m%n;
		}
		return n;
	}

	private int numerator;
	private	int denominator;
	
	public RatNum() {
		this.numerator = 0;
		this.denominator = 1;
	}

	public RatNum(int a) {
		this.numerator = a;
		this.denominator = 1;
	}

	public RatNum(int a, int b) {
		if (b == 0) {
			throw new NumberFormatException("Denominator = 0");
		}
		int divider = gcd(a,b);
		if (divider > 1) {
			a = a / divider;
			b = b / divider;
		}
		if ( a < 0 && b < 0 || b < 0) {
			a *= -1;
			b *= -1;
		}
		this.numerator = a;
		this.denominator = b;
	}

	public RatNum(RatNum r) {
		this.numerator = r.numerator;
		this.denominator = r.denominator;
	}

	public int getNumerator() {
		return this.numerator;
	}

	public int getDenominator() {
		return this.denominator;
	}
	
	public String toString() {
		return this.numerator + "/" + this.denominator; 
	}

	public double toDouble() {
		return (double)this.numerator/this.denominator;
	}
}