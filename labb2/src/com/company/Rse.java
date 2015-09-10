public class Rse {
    public static boolean allRowSumsEqual(int[][] m){
        if (m != null) {

            int summa = rowSum(m[0]); //Jamforelsetal fran summan, ska vara lika manga som arrays
                    
            boolean t = true;
            
            //Loop for att rakna och jamnfora summor i arrayen m
            for (int i = 1; i < m.length; i++) {

                int tempSum = rowSum(m[i]);

                t = tempSum == summa;
            }
            return t;
        }
        else {
            return true;
        }
    }
    public static int rowSum(int[] v){
        int sum = 0;
        if (v != null) {
            //Loop for att rakna summan for m[i]
                for(int j = 0; j <= v.length - 1; j++) {
                    sum += v[j];
                }
            return sum;
        } else {
            return 0; 
        }
    }
}
