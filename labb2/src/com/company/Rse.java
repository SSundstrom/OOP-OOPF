package com.company;

public class Rse {
    public static boolean allRowSumsEqual(int[][] m){
        int[] summa = new int[m.length]; //J�mf�relsetal f�rn summan, ska vara lika m�na som arrays
        boolean t = false;
        //Loop f�r att r�kna hur m�nga summor arrayen m inneh�ller
        for (int i = 0; i < m.length; i++) {

            summa[i] = rowSum(m[i]);
        }
        //Loop f�r att j�mf�ra alla arrays
        for(int k = 0; k < summa.length - 1; k++){
             t = summa[k] == summa[k + 1];
        }
            return t;

    }
    public static int rowSum(int[] v){
        int sum = 0;
        //Loop f�r att r�kna summan f�r m[i]
            for(int j = 0; j <= v.length - 1; j++) {
                sum += v[j];
            }
        return sum;
    }
}
