public class Euklides{
	public static void main(String[] args) {
		
		System.out.println(gcd(5, 5));
	}
	public static int gcd(int m, int n){

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
		int rest = biggestInput % smalestInput;
		while( rest != 0){
			biggestInput = smalestInput;
			smalestInput = rest;
			rest = biggestInput%smalestInput;
			if(rest == 0){
				return smalestInput;
			}			
		}
		return smalestInput;

	}
}