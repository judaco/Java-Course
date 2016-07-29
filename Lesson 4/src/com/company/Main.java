package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(sumOfDigits(123));
        System.out.println(largest(12));
        System.out.println(reverseDigits(125));
        System.out.println(squareRoot(256));
    }
    //Exercise 1 - Get a number and return the summary of all digits
    public static int sumOfDigits(int x){
        int result = 0;
        int lastdigit;
        while (x != 0) {//when x is different than 0
            lastdigit = x % 10;//calculate the remainder which is the last digits
            x /= 10;//calculate the next number to find the next last digit
            result += lastdigit;//calculate the last digit with the result until getting the sum of all digits
        }
        return result;
        // x = 123
        // last digit - 3, x = 12 ,result = 0 + 3 = 3
        // last digit - 2, x = 1, result = 3 + 2 = 5
        // last digit - 1, x = 0, result = 5 + 1 = 6
        // return 6
    }

    //Exercise 2 - Get a number and return the largest digit within the number
    public static int largest(int x){
        int result = 0;
        int lastdigit;
        while (x != 0) {// We run a while loop, as long as the num is not 0, with each iteration we get the modulo of
            //num, then check it against the current result, if it's larger,
            //then we set result as lastDigit, otherwise we continue.
            lastdigit = x % 10;//calculate the remainder which is the last digits
            x /= 10;//calculate the next number to find the next last digit
            if (lastdigit > result)//when we will find the digit which is the largest then we get the result
                result = lastdigit;
        }
        return result;
    }

    //Exercise 3 - Get a number and return the reverse digits of it
    public static int reverseDigits(int x){
        int result = 0;
        int lastdigit;
        while (x != 0) {
            lastdigit = x % 10;
            x /= 10;
            result = result * 10 + lastdigit;
        }
        return result;
        // We run a while loop, as long as the number is not 0, with each iteration we get the modulo of num,
        // then add it to the result, after multiplying the result by 10:
        /*
         * Clarifying:
         * The stages to solve this:
         * 1) We get the last digit by using -> num % 10.
         * 2) We divide the number by 10 and set it again by using -> num /= 10.
         * 3) We then multiply result by 10 so that the current last digit will move one slot to the left -> result * 10.
         * 4) We then add the last digit we got in stage 1 -> + lastDigit.
         * Ex:
         * The number is: 1234
         * This will follow the int result, each line is an iteration of the while loop:
         * 0 * 10 = 0 -> 0 + 4 = 4
         * 4 * 10 = 40 -> 40 + 3 = 43
         * 43 * 10 = 430 -> 430 + 2 = 432
         * 432 * 10 = 4320 -> 4320 + 1 = 4321
         * ---------------------------------
         * At this point num is 0 so the while loop stops working.
         */
    }
    //Exrcise 4 - Get a number and return his square root
    public static int squareRoot(int x){
        int result = 0;
        while (result * result < x)
            result++;
        return result;
    }
    /**
     * This function will return the whole square root of a number, by approximation, rounded up,
     * meaning that if a square root of a number is between 2 numbers, we'll return the larger of the both.

     * @param x - the number that we want to get the square root from.
     * @return - the square root rounded up, meaning 10 will return 4.
     */
}