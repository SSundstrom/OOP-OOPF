public class Rse {
    public static boolean allRowSumsEqual(int[][] m){
        if (m != null && m.length > 0) {

            int summa = rowSum(m[0]); //Jamforelsetal fran summan, ska vara lika manga som arrays
            
            for (int i = 1; i < m.length; i++) {
                int tempSum = rowSum(m[i]);
                if (tempSum != summa) {
                    return false;
                }
            }
        }
        return true;
    }
    public static int rowSum(int[] v){
        int sum = 0;
        if (v != null) {
                for(int j = 0; j < v.length; j++) {
                    sum += v[j];
                }
            return sum;
        } else {
            return 0; 
        }
    }
}
