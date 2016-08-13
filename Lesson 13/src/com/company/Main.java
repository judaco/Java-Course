package com.company;

public class Main {

    public static void main(String[] args) {
        Dog d1 = Dog.getDog();
        Dog d2 = Dog.getDog();
        if(d1 == d2){
            System.out.println("you see?");
        }

    }
}

//Singleton - one object max, or not at all
class Dog{

    private static Dog d;//static possessed to the class


    private Dog(){

    }

    public static Dog getDog(){//object pool - using of a deleted method, meaning it's a recycle method
        if(d == null)
            d = new Dog();
        return d;
    }

}
