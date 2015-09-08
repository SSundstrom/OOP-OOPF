package com.company;

public class Main {

    public static void main(String[] args) {
        int[][] a = {
                {1,2,1,2,1,2},
                {4,0,0,2,2,1},
                {1,1,1,1,1,4}};
        int[][] b = {
                {1,2,3,4},
                {5,6,7,8},
                {1,1,1,1}};
        Rse rse = new Rse();
        System.out.print(rse.allRowSumsEqual(a));
    }

}
