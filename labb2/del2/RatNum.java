public class RatNum {
	public static void main(String[] args) {

		System.out.println(gcd(100, 95));
	}
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

		int smallestInput = m;
		int biggestInput = n;
		if (m > n) {
			smallestInput = n;
			biggestInput = m;
		}
		if (smallestInput == 0) {
			return biggestInput;
		}

		for (int i = smallestInput; i > 0 ; i--) {
			if (m%i == 0 && n%i == 0) {
				return i;
			}
		}
		return 1;
	}
}