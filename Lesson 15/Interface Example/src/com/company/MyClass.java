package com.company;

/**
 * Created by Juda on 23/08/2016.
 */
public class MyClass {
    int x;
    int y;


    public MyClass(int x) {
        this.x = x;
    }

    static class MyStaticNestedClass{
        void stam(){
            //System.out.println(x);
        }
    }

    class MyInnerClass{
        void stam(){
            System.out.println(x);
        }
    }

    Object stam() {
        class Dog {

        }
        Dog d = new Dog();

        Circle c = new Circle(){

        };

        return d;
    }


}

interface Doable{
    void whatToDo();
}

class Circle implements Doable{

    @Override
    public void whatToDo() {

    }
}

interface Comparable{
    boolean compare(Object o);
}
