package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(distance(3, 5));
        System.out.println(product(2, 3));
        System.out.println(product2(8, 2));
        System.out.println(integrity(7, 3));
        System.out.println(remainder(9,4));
        System.out.println(power(1, 0));
        System.out.println(power2(3, 4));
    }

    //Exercise 1 - Calculate the distance between 2 numbers - using only '+' operator
    public static int distance(int x, int y) {
        int small = x;//first I set up 2 numbers which one will be the small and the other the large
        int large = y;
        if (x > y) {
            small = y;//with if loop I want to decide about the small number and the large number
            large = x;
        }
        int result = 0;//then my result will determine the distance between the 2 numbers
        while (result + small < large)
            result++;
        return result;
    }

    //Exercise 2 - Calculate the product of X and Y - using only '+' operator
    public static int product(int x, int y) {
        int small = x;//again I will determine the small and the large number between x and y
        int large = y;
        if (x > y) {
            small = y;
            large = x;
        }
        int result = 0;
        for (int i = 0; i < small; i++)
            result += large;//now each time 'i' will be small than my small number 'i' adds the large number
        return result;//to the result again and again until the 'i' will be same as small - x+x+x / y+yy
    }

    //Exercise 2 - other option
    public static int product2(int x, int y) {
        int result = 0;
        for (int i = 0; i < x; i++)
            result += y;
        return result;
    }

    //Excercise 3 - Calculate how many time Y enters in X - using only '+' operator
    public static int integrity(int x, int y) {
        if (y == 0)//0 cannot enter even one time in any number = false
            return -1;
        int d = y;//d is the sum
        int i = 0;//'i' determines the number of times X enters in Y
        while (d <= x) {//calculating the sum while 'i' increasing until the sum will be greater or equal to X
            d += y;//each time the sum is less than X I'll increase the sum, and I will add 'i'
            i++;
        }
        return i;
    }

    //Exercise 3 other option
    public static int quotient(int x, int y) {
        if (y == 0)//0 cannot enter even one time in any number = false
            return -1;
        int count = 0;
        int sum = y;
        while (sum <= x) {
            count++;
            sum += y;
        }
        return count;
    }

    //Exercise 4 - Calculate the remainder (She'erit) between X and Y
    public static int remainder(int x, int y) {
        if (y == 0)
            return -1;
        return distance(x, product(quotient(x, y), y));

        //return distance(9, product(quotient(9, 4), 4));
        //return distance(9, product(2, 4));
        //return distance(9, 8);
        //return 1;
    }

    //Exercise 5 - the power (Hezka) of X in Y
    public static int power(int x, int y) {
        if (x == 0) {
            if (y == 0)
                return -1;
            return 0;
        }
        if (y == 0 || x == 1)
            return 1;
        int result = x;
        for (int i = 1; i < y; i++)
            result *= x;
        return result;
    }

    //Excercise 6 - the power of X in Y - without using 'While or For'
    public static int power2(int x, int y) {
        if (x == 0) {
            if (y == 0)
                return -1;//0 in power of 0 is false!
            return 0;//so return 0
        }
        if (y == 0 || x == 1)//1 in power 0 is 1 - cause any number for nothing (0) is 1
            return 1;
        return power2(x, y - 1) * x;
    }
    //power(3,4)
    //power(3,3) * 3
    //((power(3,2) * 3) * 3
    //(((power(3,1) * 3) * 3) * 3
    //((((power(3,0) *3) *3) *3) *3
    //(((1 * 3) * 3) * 3) *3
    //((3 * 3) *3) *3
    //(9 * 3) * 3
    //27 * 3
    //81
}
