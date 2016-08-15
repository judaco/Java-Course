package com.company;

public class Enum {

    public static void main(String[] args) {
        PrinterType p = PrinterType.INKJET;
        if (p == PrinterType.DOTMATRIX){

        }
        switch (p){
            case DOTMATRIX:
                break;
            case LASER:
                break;
            case INKJET:
                break;
            case THREE_DIMENSIONS:
                break;
            case THERMAL:
                break;
        }
        System.out.println(p.getCapacity());
    }
}
enum PrinterType{//a close list of values, not so using in JAVA
    DOTMATRIX(5), INKJET(15), LASER(100), THREE_DIMENSIONS(0), THERMAL(1000);

    private int capacity;

    private PrinterType(int capacity){
        this.capacity = capacity;
    }
    public int getCapacity(){
        return capacity;
    }
}
