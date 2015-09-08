public class Rse1 {

	public static void main(String[] args){
		
		int [][] v = { 	{2,3,4,5},
						{6,8,9,0} };

		int sum;
		


		for ( int j = 0 ; j < v.length() ; j++ ) {
			sum = sum + v[j];
		}
		System.out.println(sum);
	}

/*
	public static int rowSum(int[] v) {
		int sum;
		for ( int j = 0 ; j < v[].length() ; j++ ) {
			sum += v[j];
		}
		return sum;
	}
*/
}