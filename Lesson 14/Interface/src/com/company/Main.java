package com.company;

public class Main {

    public static void main(String[] args) {
        Rollable rollable = new Dog();//pointer rollable points on new object of type Dog
        rollable.roll(13);
    }
}
interface Jumpable{
    void jump();
}
interface Edible{
    void eat();
}
interface Speakable{
    void speak();
    void talk();
}
interface Countable{
    int count();
}
interface Rollable{
    void roll(float degree);
}
class Animal{

}
class Dog extends Animal implements Rollable, Countable{//I must implement the all methods inside of the interfaces
    //like in Interface Speakable, I must implement the methods - speak() and talk().

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void roll(float degree) {

    }
}
