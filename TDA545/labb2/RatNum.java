public class RatNum {
	private int numerator;
	private int denominator;

	public RatNum div(RatNum r){
		int num = this.numerator * r.getDenominator();
		int dem = this.denominator * r.getNumerator();
		RatNum rn = new RatNum(num ,dem);
		return rn;
	}

	public RatNum mul(RatNum r){
		int num = this.numerator * r.getNumerator();
		int dem = this.denominator * r.getDenominator();
		RatNum rn = new RatNum(num, dem);
		return rn;
	}

	public RatNum sub(RatNum r){
		int dem = this.denominator * r.getDenominator();
		int num = (this.numerator * r.getDenominator()) - 
		(r.getNumerator() * this.denominator);
		RatNum rn = new RatNum(num , dem);
		return rn;
	}

	public boolean equals(Object r) {
		if (r == this) {
			return true;
		}
		if (r instanceof RatNum) {
			RatNum rRat = (RatNum) r;
			int restR = gcd((rRat.getNumerator()), rRat.getDenominator());			
			int restThis = gcd(this.numerator, this.denominator);

			if (rRat.getDenominator()/restR == this.denominator/restThis 
				&& (rRat.getNumerator())/restR == this.numerator/restThis) {
				return true;
			}
		}

		return false;
	} 

	public boolean lessThan(RatNum r) { 
		if ( r.getNumerator() * this.denominator
			> this.numerator * r.getDenominator() ) {
			return true;
		}
		return false;
	}

	public RatNum add (RatNum r) {
		int dem = this.denominator * r.getDenominator();
		int num = (this.numerator * r.getDenominator()) 
					+ (r.getNumerator() * this.denominator);
		RatNum rn = new RatNum(num, dem);

		return rn;
	}

	


	public static RatNum parse(String s){
		int num =0, dem =1;
		String[] tmp = s.split("/");
		RatNum rn = new RatNum();
		if (tmp.length == 2) {	
				rn.numerator = Integer.parseInt(tmp[0]);
				rn.denominator = Integer.parseInt(tmp[1]);
			
		} else {
			rn.denominator = 1;
			rn.numerator = Integer.parseInt(s);
		}
	
		return rn;
	}
	public RatNum(String s){
		this(parse(s));
		
	}

	public double toDouble(){
		return (double)this.numerator / this.denominator;
	}
	public String toString(){
		return this.numerator + "/" + this.denominator;
	}
	//Del 2
	public RatNum(){
		 this.numerator = 0;
		 this.denominator = 1;
	}
	public RatNum(int a){
		this.denominator = 1;
		this.numerator = a;
	}
	public RatNum(int a, int b){
		if(b == 0){
			throw new NumberFormatException("Denominator = 0");
		}	
		int divider = gcd(a,b);
		if(divider > 1){
			a = a / divider;
			b = b / divider;
		}
		if(a < 0 && b < 0 || b < 0){
			a = a * -1;
			b *= -1;
		}
		this.numerator = a;
		this.denominator = b;
	}
	public RatNum(RatNum r){
		this.numerator = r.getNumerator();
		this.denominator = r.getDenominator();
	}
	public int getNumerator(){
		return this.numerator;
	}
	public int getDenominator(){
		return this.denominator;
	}
	//Del 1
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
}