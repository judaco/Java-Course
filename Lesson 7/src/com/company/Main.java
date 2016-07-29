package com.company;

public class Main {

    public static void main(String[] args) {
        int[] nums = {15, -20, -30, 40, 50};
        System.out.println(maxArray(nums));
        System.out.println(avg(nums));
        int[] arr1 = {1, 3, 5, 7, 9, 11};
        int[] arr2 = {7, 9, 11};
        System.out.println(subArray(arr1, arr2));
        int[] arr = {15, 35, 65, 95, 75};
        printArr(arr);
        sort(arr);
    }

    //Exercise 1 - Get an Array (of numbers) and return the largest number on the Array
    public static int maxArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        return max;
        // If the nums variable is null, we need to throw an exception.
        //TODO: throw exception if nums == null. Later on when we learn it.
    }

    //Exercise 2 - Gat an Array (of numbers) and return the average of them
    public static double avg(int[] nums) {
        double sum = 0;//loop through the array giving us the current index it's at:
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += num;
        }
        return sum / nums.length;
    }

    //Exercise 2 - other option - short for loop
    private static double avg2(int[] nums) {
        double sum = 0;//just loops through the array and gives us the current element it's at: A short-handed for loop.
        for (int num : nums) {
            sum += num;
        }
        return sum / nums.length;
    }

    //Exercise 3 - find a match of sub array in 2 Arrays A and B
    public static boolean subArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            return false;// >> If either of them is null they aren't a part of each other, therefore we return false.
        }
        // >> If the second array is empty, we can say that it's a part of the first array, since 0 is a part of 6 (6 + 0 = 6).
        if (arr2.length == 0)
            return true;
        for (int i = 0; i <= arr1.length - arr2.length; i++) {
            if (arr2[0] == arr1[i]) {
                boolean match = true;
                for (int j = 1; j < arr2.length; j++) {
                    if (arr1[i + j] != arr2[j]) {
                        match = false;
                        break;
                    }
                }
                if (match)
                    return true;
            }
        }
        return false;
    }

    /**
     * This function is used to see if an array is a part of a different array, meaning all the elements in the second array,
     * exist in the first array, in the same order.
     *
     * @param arr1 - the first array.
     * @param arr2 - the second array.
     * @return - true if arr2 is part of arr1, and appears in the same order, false otherwise.
     */

    //Exercise 4 - Print an Array
    public static void printArr(int[] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        if (arr.length > 0)
            System.out.print(arr[arr.length - 1]);
        System.out.println("}");
    }

    //Exercise 4 continue - Sort an array - by Bubble Sort
    public static void sort(int[] arr) {
        boolean isSorted = false;
        int upTo = arr.length - 1;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < upTo; i++) {
                if (arr[i] > arr[i + 1]) {
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
}
    /**
     * This function will sort an array of integers.<br>
     * We don't need to return the int array since the arr is a pointer to the address in the memory where the values are stored,<br>
     * once we sort the array, the user of the function still has the pointer of the array, but now the pointer's values are sorted.<br>
     * <br>
     * The way we'll sort the array is:<br>
     * <ul>
     * <li>
     * 1. We first set up two parameters: <br>
     * [I] A boolean - isSorted, to indicate if the array is sorted.<br>
     * [II] An integer called upTo, telling us up to what number the for loop will run(the number of iterations).<br></li>
     * <li>2. We then create a while loop that will run as long as the array is not sorted.<br></li>
     * <li>3. Then we set the boolean to true, assuming the list is sorted.</li>
     * <li>4. We run a for loop up to the integer upTo.</li>
     * <li>5. We now check to see if the value at i is greater than the value at i+1, if so we switch the position.</li>
     * <li>6. If .5. has happened, then we know that the array isn't sorted, so isSorted = false.</li>
     * <li>7. Now we reduce the the upTo by one.</li>
     * <li>8. Now we run it again.</li>
     * </ul>
     * <p>
     * Example:
     * Arr = {5,3,7,1,4}.
     * isSorted = false.
     * Starting while loop...
     * ----------------------------------------
     * isSorted = true.
     * upTo = 4.
     * For loop starting.
     * arr[0] > arr[1] ? True, now switch.
     * {3,5,7,1,4}
     * isSorted = false.
     * arr[1] > arr[2] ? False.
     * arr[2] > arr[3] ? True, now switch.
     * {3,5,1,7,4}
     * arr[3] > arr[4] ? True, now switch.
     * {3,5,1,4,7}
     * For loop ending.
     * upTo = 3 now since we finished the loop and the last number is in the correct position.
     * ----------------------------------------
     * isSorted = true.
     * upTo = 3.
     * For loop starting.
     * {3,5,1,4,7}
     * arr[0] > arr[1] ? False.
     * arr[1] > arr[2] ? True, now switch.
     * isSorted = false.
     * {3,1,5,4,7}
     * arr[2] > arr[3] ? True, now switch.
     * {3,1,4,5,7}
     * For loop ending.
     * upTo = 2 now we finished the loop and the two last number are at the correct position.
     * ----------------------------------------
     * isSorted = true.
     * upTo = 2.
     * For loop starting.
     * {3,1,4,5,7}
     * arr[0] > arr[1] ? True. now switch.
     * isSorted = false.
     * {1,3,4,5,7}
     * arr[1] > arr[2] ? False.
     * For loop ending.
     * upTo = 1 now we finished the loop and the three last numbers are at the correct position.
     * ----------------------------------------
     * isSorted = tue.
     * upTo = 1.
     * For loop starting.
     * {1,3,4,5,7}
     * arr[0] > arr[1] ? False.
     * For loop ending.
     * isSorted is true so the array is sorted, ending while loop.
     * @param arr
     */