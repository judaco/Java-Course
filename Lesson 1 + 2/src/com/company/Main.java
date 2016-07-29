package com.company;

public class Main {

    public static void main(String[] args) {
        int x = 8; //4 bytes;
        byte b = 100; //1 byte -128 to 127
        short s = 15; //2 bytes 65,536
        long l = 148L; //8 bytes

        float fl = 234.23f; //4 bytes
        double d = 234234.5; //8 bytes

        char c = 'h'; //1 byte
        boolean f = false;

        String myString = "hello";
        myString = "world";

        x = (5 + 2) * 2;
        x = 5 / 2; //result is 2

        f = x != 2 || 5 < 12;
        f = !(5 < 9);
        // 5*(2+3) = 5*2 + 5*3
        boolean f1 = true, f2 = false;

        //2X 2*2 = 4
        //X + X  2 + 2  = 4

        boolean f3 = !(f1 && f2);
        f3 = !f1 || !f2;
        System.out.println(f);

    }

}