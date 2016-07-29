package com.company;

public class Main {

    public static void main(String[] args) {
        drawTangle(5,5);
        drawRectangle(6,6);
        drawX(5);
        centerTangle(5,5,5,5);
        System.out.println(sqrtPrecise(4));
        drawCircle(10,10,5);
    }
    //Exercise 1 - Draw a Tangle by using width and height with '*' - Not Optimized
    public static void drawTangle(int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(i == 0 || i == height - 1 || j == 0 || j == width - 1 ? "*" : " ");
            }
            System.out.println();
        }
        //This function is used to draw a rectangle with a certain width and height.
        //Note: This function is not optimized.
    }
    //Exercise 1 - Optimized version
    public static void drawRectangle(int width, int height) {
        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < height - 2; i++) {
            System.out.print("*");
            for (int j = 0; j < width - 2; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }
        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    //Exerciese 2 - Draw a X by using width and height with '*'
    public static void drawX(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print( i==j || i + j == size-1 ? "*" : " ");
            }
            System.out.println();
        }
        /*This function is used to draw an X of a certain size, meaning the size is the complete height of X.<br>
        * Note: This function is not optimized.
        *
        * @param size - the height of the X.*/
    }
    //Exercise 3 - Put x and y and Center the Tangle
    public static void centerTangle(int x, int y, int width, int height){
        for (int i = 0; i < y ; i++) {
            System.out.println();
        }
        for (int i = 0; i < height ; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < width; j++) {
                System.out.print(i == 0 || i == height - 1 || j == 0 || j == width - 1 ? "*" : " ");
            }
            System.out.println();
        }
    }
    //Exercise Other - Square Root none Integer (using of double)
    public static double abs(double x){
        return x < 0 ? -x : x;
    }

    public static double sqrtPrecise(double x){
        double result = 0;
        double add = 1000;
        int count = 0;
        while (abs(x - result * result) > 0.00001){
            while((result + add) * (result + add) >= x){
                add /= 10;
                count++;
            }result += add;
            System.out.println(count);
        }return result;
    }
    //Exercise 4 - Draw a Circle
    public static void drawCircle(int a, int b, int radius) {
        for (int i = 0; i < b + radius + 10; i++) {
            for (int j = 0; j < a + radius + 10; j++) {
                System.out.print(isPointOnCircle(a, b, radius, j, i) ? "*" : " ");
            }
            System.out.println();
        }
        /**
         * This function is used to draw a circle on the screen when (a,b) is the center of the circle.
         * Note #1 : This function is not optimized.
         * Note #2 : Parameters a and b must be larger then radius.
         *
         * @param a      - the X position of the center of the circle.
         * @param b      - the Y position of the center of the circle.
         * @param radius - the radius of the circle.
         */
    }
    public static boolean isPointOnCircle(int a, int b, int radius, int x, int y) {
        int deltaX = a - x;
        int deltaY = b - y;
        int difference = (deltaX * deltaX + deltaY * deltaY) - radius * radius;
        if (difference < 0)
            difference *= -1;
        return difference < 5;
    }
    /**
     * This function is used with {@link #drawCircle(int, int, int)}  in order to know if a position of a point is on the circle.
     * Note: This function will use the function X^2 + Y^2 = R^2, which represents the circle,
     * but since we are using integers, which are whole numbers, we will almost never get an exact match.
     * Therefore we add a difference consideration,, with the 'difference' parameter.
     *
     * @param a      - the X position of the center of the circle.
     * @param b      - the Y position of the center of the circle.
     * @param radius - the radius of the circle.
     * @param x      - the X position of the point we want to check.
     * @param y      - the Y position of the point we want to check.
     * @return - true if the point is on the circle, false otherwise.
     */
}