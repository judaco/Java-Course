package com.company;

public class Main {

    public static void main(String[] args) {
        int[] nums = {4, 7, 2, 5, 3, 6};
        int[] arr1 = {15, 35, 65, 95, 75};
        sort2(arr1);
        reverseOrder(nums);
        int[] anArray = {2, -2, -3, 7, 4, -1};
        System.out.println(seqMaxSum(anArray));
        System.out.println(maxSubArray(nums));
        int [] left = {5,8,2,6,4,3,9};
        int [] right = {-2,-4,7,19,1,0};
        int [] middle = {-3,10,13};
        mergeSort(nums, 0, nums.length - 1);

        // >> By writing the following statement, we set a pointer, which basically just points to a memory address.
        int[] x = new int[] {8};
        // >> This statement, does not change the previous memory address, but instead changes the pointer to a different one, whilst making the previous memory address not accessible.
        x = new int[]{9};
        // >> By writing this, we created a new pointer that points to the pointer x, which in turn points to a memory address.
        int[] y = x;
        // >> Therefore, by writing this statement, we also change the value of y[0], since it's the memory address we're changing, not the pointer itself.
        x[0]++;
        // >> Here we'll get '10'.
        System.out.println(y[0]);

        // >> Same here, by creating two new pointers, we basically point to new addresses.
        String s1 = "hello";
        String s2 = s1;
        // >> By adding the following string, we create a new memory address containing the value of s1, and making the previous address unaccessible.
        s1 += " world";
        // >> These are examples of primitive types, that have an object, and therefore are pointers to a memory address.
        Integer i = 3;
        Double d = 123.3;

        // >> The following example is used to show how you change switch two values.
        int a = 3;
        int b = 5;
        int temp = a;
        a = b;
        b = temp;

    }
    //Exercise 5 - Sort an Array from the largest num to the smallest - changing the if (<) for the opposite
    public static void sort2(int[] arr) {
        boolean isSorted = false;
        int upTo = arr.length - 1;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < upTo; i++) {
                if (arr[i] < arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isSorted = false;
                }
            }
            upTo--;
        }
        System.out.print("{");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        if (arr.length > 0)
            System.out.print(arr[arr.length - 1]);
        System.out.println("}");
    }

    //Exercise 5 - Sort an Array from the last number to the first number (reverse order)
    public static void reverseOrder(int[] nums) {
        int temp, adjacent;// The number of iterations in the for loop.
        int upTo = nums.length / 2;
        for (int i = 0; i < upTo; i++) {// This will switch the 2 values, adjacent is used to not run the calculation nums.length - i - 1 multiple times.
            temp = nums[i];
            adjacent = nums.length - i - 1;
            nums[i] = nums[adjacent];
            nums[adjacent] = temp;
        }
        System.out.print("{");
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.print(nums[i] + ",");
        }
        if (nums.length > 0)
            System.out.print(nums[nums.length - 1]);
        System.out.println("}");
    }
    //Exercise 6 - find the biggest sum of sequence in Array (max sub array) - My solution
    public static int seqMaxSum(int[ ] anArray) {
        int sum = 0;
        int max = 0;
        for (int i=0; i < anArray.length; i++) {
            sum += anArray[i];
            if (max < sum)
                max = sum;
            else if (sum < 0)
                sum = 0;
        }
        return max;
    }
    //Exercise 6 - Elad's solution
    public static int maxSubArray(int[] nums) {
        // The largest sum so far.
        int maxSoFar = 0;
        // The sum at position i in the loop.
        int maxEndingHere = 0;
        for (int i = 0; i < nums.length; i++) {// We first add the current number to the sum at position i [maxEndingHere]
            maxEndingHere += nums[i];//If the sum at i is negative we can assume the largest sub array isn't in the previous numbers so we reset it.
            if (maxEndingHere < 0)
                maxEndingHere = 0;// If the sum at i is positive and larger than the largest sum so far than we can se it to maxSoFar to indicate the largest sub array so far.
            if (maxSoFar < maxEndingHere)
                maxSoFar = maxEndingHere;
        }
        return maxSoFar;
    }
    //Exrcise 7 - Sort an array by Quick Sort
    public static int partition(int[] arr1, int low, int high) {
        int pivot = arr1[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr1[j] <= pivot) {
                i++;
                int temp = arr1[i];
                arr1[i] = arr1[j];
                arr1[j] = temp;
            }
        }
        int temp = arr1[i + 1];
        arr1[i + 1] = arr1[high];
        arr1[high] = temp;
        return i + 1;
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }
    // Exercise 8 - Sort 2 arrays to 1 array by Merge Sort
    public static void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int leftArray[] = new int[n1];
        int rightArray[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArray[i] = arr[middle + 1 + i];
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }

    }
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
        System.out.print("{");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        if (arr.length > 0)
            System.out.print(arr[arr.length - 1]);
        System.out.println("}");
    }
}
