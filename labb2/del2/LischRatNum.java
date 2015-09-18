public class LischRatNum {
	private int numerator;
	private int denominator;

	public LischRatNum div(LischRatNum r){
		int num = this.numerator * r.denominator;
		int dem = this.denominator * r.numerator;
		LischRatNum rn = new LischRatNum(num ,dem);
		return rn;
	}

	public LischRatNum mul(LischRatNum r){
		int num = this.numerator * r.numerator;
		int dem = this.denominator * r.denominator;
		LischRatNum rn = new LischRatNum(num, dem);
		return rn;
	}

	public LischRatNum sub(LischRatNum r){	//TODO negativ
		int dem = this.denominator * r.denominator;
		int num = (this.numerator * r.denominator) - 
		(r.numerator * this.denominator);
		LischRatNum rn = new LischRatNum(num , dem);
		return rn;
	}

	public boolean equals(LischRatNum r) {
		
		int restR = gcd(r.numerator, r.denominator);
		int restThis = gcd(this.numerator, this.denominator);

		if (r.denominator/restR == this.denominator/restThis 
			&& r.numerator/restR == this.numerator/restThis) {
			
			return true;
		}
		return false;
	}

	public boolean lessThan(LischRatNum r) { 
		if ( r.numerator * this.denominator
			< this.numerator * r.denominator ) { 
			return true;
		}
		return false;
	}

	public LischRatNum add (LischRatNum r) {
		
		int dem = this.denominator * r.denominator;
		int num = (this.numerator * r.denominator) 
					+ (r.numerator * this.denominator);
		LischRatNum rn = new LischRatNum(num, dem);

		return rn;
	}

	


	public static int[] parse(String s){
		int num =0, dem =0;
		int[] answer = new int[2];
		String[] tmp;
		if(s.contains("/")){
			try {
				tmp = s.split("/");
				num = Integer.parseInt(tmp[0]);
				dem = Integer.parseInt(tmp[1]);
				answer[0] = num;
				answer[1] = dem;
			} catch (NumberFormatException e){
				System.out.print("Nu blev det fel pga inget '/'");
			}
		} else {
			try {
				num = Integer.parseInt(s);
				answer[0] = num;
				answer[1] = 1;
			} catch (NumberFormatException f){
				System.out.print("Nu blev det fel pga inget 'heltal'");
			}
		}
		return answer;
	}
	public LischRatNum(String s){
		int[] svar = parse(s);
		this.numerator = svar[0];
		this.denominator = svar[1];
	}

	public double toDouble(){
		return (double)this.numerator / (double)this.denominator;
	}
	public String toString(){
		return this.numerator + "/" + this.denominator;
	}
	//Del 2
	public LischRatNum(){
		 this.numerator = 0;
		 this.denominator = 1;
	}
	public LischRatNum(int a){
		this.denominator = 1;
		this.numerator = a;
	}
	public LischRatNum(int a, int b){
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
	public LischRatNum(LischRatNum r){
		this.numerator = r.numerator;
		this.denominator = r.denominator;
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