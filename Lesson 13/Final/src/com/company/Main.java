package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(Car.MAX_SPEED);
    }
}

class Car{

    private static int x;
    private static int y;

    static {//static constructor
        x = 5;
        y = 6;
    }

    private static int counter = 0;

    private final int year;//Final - prevent an inheritance from the class - meaning I cannot make an extends
    //I could determine a value once, and nobody can change it from outside, and nobody can use my class.

    public static final int MAX_SPEED = 200;//this is a "Constant" meaning - Kavu'a - static belongs to the class

    public Car(int year){
        this.year = year;
        counter++;//will count how many object I have in my class
    }

    public void setYear(int year){
        //this.year = year;
    }
}

final class Dog{
    String name;
}