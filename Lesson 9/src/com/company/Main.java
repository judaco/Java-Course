package com.company;


import graphicshape.Circle;
//import graphicshape.Shape;

public class Main {

    public static void main(String[] args) {
        //Object Oriented Programming Principles:
        //Encapsulation
        //Inheritance
        //Polymorphism
        //Abstraction


        //Access Modifier:
        //Public
        //Private
        //Protected
        //Default


        //what "new" does?
        //1. find free space in the heap that is large enough to contain the Object
        //2. Mark the space as "taken"
        //3. Initialize the space in memory
        //4. returns the address in memory that the object was created in.

	    /*
        Shape s = new Shape();
        s.color = 14567;
        System.out.println(s.color);
        Circle c = new Circle();
        c.color = 123;
        */

        Circle circle = new Circle();
        System.out.println(circle.area());


        Dog d = new Dog();
        d.name = "Snoopy";
        //d.bark();
        Animal a = d;
        a.makeSound();


        int x = 5;
        Integer i = x;
        int y = i;
        Float f = 34.0f;
        //Double d = 15.4;
        Long l = 234L;


        Boolean b = true;
    }
}

    class Animal {
        void makeSound() {
            System.out.println("some sound");
        }
    }

    class Dog extends Animal {
        String name;

        void bark() {
            System.out.println("baf.. baf.. " + name);
        }

        void makeSound() {
            bark();
        }

    }

    class Cat extends Animal {
        void growl() {
            System.out.println("mio mio");
        }

        void makeSound() {
            growl();
        }
    }
