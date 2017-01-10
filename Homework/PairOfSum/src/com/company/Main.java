package com.company;

import java.io.*;

import static com.company.PairOfSum.pairs;

public class Main {

    public static void main(String[] args) {
        int Array[] = {5, 8, 1, 4, 3, 17, 30, 41, 15, 20};
        int sum = 20;
        pairs (Array, sum);
    }
}
class PairOfSum {
    private static final int Max = 10000;//this is the max size of the hashmap

    static void pairs (int arr[], int sum){
        boolean [] myBinaryMap = new boolean[Max];//initialize all the array as false

        for (int i = 0; i < arr.length; i++) {
            int temp = sum - arr[i];
            if (temp >= 0 && myBinaryMap [temp]){//the condition - If M[x - A[i]] is set then print the pair (A[i], x - A[i])
                System.out.println("Pair with given sum " +
                        sum + " is (" + arr[i] +
                        ", "+temp+")");
            }
            myBinaryMap[arr[i]] = true;//Set M[A[i]]
        }

    }
}