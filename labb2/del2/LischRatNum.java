public class LischRatNum {
	private int numerator;
	private int denominator;


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
		LischRatNum(svar[0], svar[1]);
		System.out.println(this.numerator);
		System.out.println(this.denominator);
	}

	public double toDouble(){
		return this.numerator / this.denominator;
	}
	public String toString(){
		return (double)this.numerator + "/" + (double)this.denominator;
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