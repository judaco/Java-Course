package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 2, 1, 2, 3, 3};
        printMoreThanNd4(arr);
    }

    static class ElementCount{
        public ElementCount(int element, int counter) {
            this.element = element;
            this.counter = counter;
        }

        int element;
        int counter;
    }

    static void printMoreThanNd4(int[] arr){
        int k = 4 - 1;
        ElementCount[] elementCount = new ElementCount[k];

        //Step 1 - initializing our temporary counting array
        for (int i = 0; i < elementCount.length; i++)
            elementCount[i] = new ElementCount(123,0);
        //Step 2 - process all the elements in the array
        for (int i = 0; i < arr.length; i++) {
            int j;
            for(j = 0; j < k; j++){
                if( arr [i] == elementCount[j].element){
                    elementCount[j].counter++;
                    break;
                }
            }

            if(j == k){
                int l;
                for ( l = 0 ; l < k; l++){
                    if(elementCount[l].counter == 0){
                        elementCount[l].element = arr[i];
                        elementCount[l].counter = 1;
                        break;
                    }
                }
                if( l == k){
                    for( l = 0; l < k; l++){
                        elementCount[l].counter--;
                    }
                }
            }
        }

        //Step 3 - check the actual count
        for (int i = 0; i < k; i++) {
            int actualCount = 0;
            for (int j = 0; j < arr.length; j++) {
                if(arr[j] == elementCount[i].element)
                    actualCount++;
            }
            if(actualCount > arr.length/( k + 1 ))
                System.out.println(elementCount[i].element);
        }
    }


    static int fib(int n){
        if(n==1 || n==2)
            return 1;
        //return fib(n-1) + fib(n-2);
        int a = 0;
        int b = 1;
        int c;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
