package com.company;

/**
 * Created by Juda on 13/08/2016.
 */
public class Overloaded {

    /*
    public static void aMethod(int val){ System.out.println("int"); }
    public static void aMethod(short val){ System.out.println("short"); }
    public static void aMethod(Object val){ System.out.println("object"); }
    public static void aMethod(String val){ System.out.println("String"); }
    */


    /*public static void aMethod(short val){ System.out.println("short"); }
    public static void aMethod(byte val){ System.out.println("byte"); }*/

    public static void aMethod(long val1, int val2){ System.out.println("long,int"); }
    public static void aMethod(int val1, long val2){ System.out.println("int,long"); }

    public static void go(){

        /*
        byte b = 9;
        aMethod(b);
        aMethod(9);
        Integer i = 9;
        aMethod(i);
        aMethod("9");
        */

        //aMethod(9);
        //aMethod(9,10);
    }
}
class Animal{
    private void foo(){

    }

    public void too(){
        foo();
    }
}

class Dog extends Animal{

    void goo(){
        too();
    }

    /*
    @Override
    protected void too() {
        super.too();
    }
    */
}
