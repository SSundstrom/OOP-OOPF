public class Euklides{
	public static void main(String[] args) {
		
		System.out.println(gcd(0, -20));
	}
	public static int gcd(int m, int n){
		
		int rest = 1;

		if(m == 0 && n == 0){
			throw new IllegalArgumentException();
		}
		int biggestInput = m;
		int smalestInput = n;
		if(n > m){
			biggestInput = n;
			smalestInput = m;
		}

		if(biggestInput < 0){
			biggestInput = biggestInput * -1;
		}
		if(smalestInput < 0){
			smalestInput = smalestInput * -1;
		}
		if(smalestInput == 0){
			return biggestInput;
		}

		while( rest != 0){
			rest = biggestInput%smalestInput;
			if(rest == 0){
				return smalestInput;
			} else{
				biggestInput = smalestInput;
				smalestInput = rest;
			}
		}
		return 1;

	}
}