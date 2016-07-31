package com.company;

public class Main {

    public static void main(String[] args) {
        Animal [] farmAnimlas;
        farmAnimlas = new Animal[4];

        farmAnimlas[0] = new Cow();
        farmAnimlas[1] = new Rooster();
        farmAnimlas[2] = new Sheep();
        farmAnimlas[3] = new Duck();

        for (int i = 0; i < farmAnimals.length; i++) {
            farmAnimals[i].makeSound();
        }
    }
}

class Animal{
    void makeSound(){
        System.out.println("some sound");
    }
}

class Cow extends Animal{
    void moo(){
        System.out.println("Moooo...");
    }
    void makeSound(){
        moo();
    }
}
class Rooster extends Animal{
    void crow(){
        System.out.println("Ku..Ku..Ri..Ku");
    }
    void makeSound(){
        crow();
    }
}
class Sheep extends Animal{
    void bleat(){
        System.out.println("Meee...Meee...");
    }
    void makeSound(){
        bleat();
    }
}
class Duck extends Animal{
    void quack(){
        System.out.println("Qua...Qua...");
    }
    void makeSound(){
        quack();
    }
}
