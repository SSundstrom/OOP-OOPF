package com.company;

public class Rse {
    public static boolean allRowSumsEqual(int[][] m){
        int[] summa = new int[m.length]; //Jämförelsetal fårn summan, ska vara lika måna som arrays
        boolean t = false;
        //Loop för att räkna hur många summor arrayen m innehåller
        for (int i = 0; i < m.length; i++) {

            summa[i] = rowSum(m[i]);
        }
        //Loop för att jämföra alla arrays
        for(int k = 0; k < summa.length - 1; k++){
             t = summa[k] == summa[k + 1];
        }
            return t;

    }
    public static int rowSum(int[] v){
        int sum = 0;
        //Loop för att räkna summan för m[i]
            for(int j = 0; j <= v.length - 1; j++) {
                sum += v[j];
            }
        return sum;
    }
}
