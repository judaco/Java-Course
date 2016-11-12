package com.company;

import static java.lang.System.out;
import static java.lang.System.setOut;

public class Main {

    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 2, 2, 2, 3, 4, 5};
        int z = 2;
    }

    public static int findZ(int[] a, int z) {
        for (int i = 0; i < a.length; i++) {
            if (z == a[i])
                return i;
        }
        return -1;
           
    }
    
    public static int dup (int [] a, int z){
        for (int i = 0; i < z; i++) {
            for (int j = i + 1 ; j < z ; j++) {
                if (a[i] == a[j])
                    System.out.println(a[i] + " ");
            }
        }
        return z;
    }
}
