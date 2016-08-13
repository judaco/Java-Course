package com.company;

/**
 * Created by Juda on 13/08/2016.
 */
public class HappyBirthday {
    public static void wish(String name){//overloading - using 2 function by same name by 2 other patterns
        System.out.println("Happy birthday " + name + "!");
    }

    public static void wish(){
        wish("to you");
    }
}
