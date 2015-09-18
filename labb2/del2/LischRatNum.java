public class RatNumLocal {
	private int numerator;
	private int denominator;


	public static RatNumLocal parse(String s){
		int num =0, dem =0;
		RatNumLocal answer = new RatNumLocal;
		String[] tmp;
		if(s.contains("/")){
			try{
				tmp = s.split("/");
				num = Integer.parseInt(tmp[0]);
				dem = Integer.parseInt(tmp[1]);
				return RatNumLocal(num, dem);
			}catch (NumberFormatException e){
				return -1.0;
			}else{
				try{
					num = Integer.parseInt(s);
					dem = 1;
				}
			}
		}
		/*else if(tmp.length < 1){
			try{
				dblNum = Integer.parseInt(s);
				answer = dblNum * 1.0;
			}catch (NumberFormatException f){
				return -1.0;
			}	
		} */
		return answer;



		/*try {			
			String[] tmp = s.split("/");
			System.out.print(tmp[0]);
			if(1 < tmp.length){
				dblNum = Integer.parseInt(tmp[0]);
				dblDem =  Integer.parseInt(tmp[1]);
			}
			answer = (double)dblNum / (double)dblDem;
			return answer;
		} catch (NumberFormatException e){
			return -1.0;
		}
			*/

	}
	public double toDouble(){
		return this.numerator / this.denominator;
	}
	public String toString(){
		return (double)this.numerator + "/" + (double)this.denominator;
	}
	//Del 2
	public RatNumLocal(){
		 this.numerator = 0;
		 this.denominator = 1;
	}
	public RatNumLocal(int a){
		this.denominator = 1;
		this.numerator = a;
	}
	public RatNumLocal(int a, int b){
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
	public RatNumLocal(RatNumLocal r){
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