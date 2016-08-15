package com.company;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        MyClass.MyStaticNestedClass myStaticNestedClass = new MyClass.MyStaticNestedClass();

        MyClass myClass = new MyClass();
        myClass.x = 8;
        MyClass.MyInnerClass myInnerClass = myClass.new MyInnerClass();//specific object has this class
        MyClass.MyInnerClass myInnerClass2 = myClass.new MyInnerClass();
        myInnerClass.foo();

        Object o = myClass.foo();
        System.out.println(o.toString());

        Animal a = myClass.koo();
        a.makedSound();

        //MyClass.MyInnerClass myInnerClass2 = new MyClass().new MyInnerClass();

        Animal anim = new Animal(){//Anonymous Class - one case only
            @Override
            public void makedSound() {//drisa shel my makedSound from my inheritance class (Animal)
                System.out.println("anonymous");
            }
        };
        anim.makedSound();
    }
    MyAbstractClass myAbstractClass = new MyAbstractClass() {//Intellij created for me an anonymous class
        @Override
        public void myAbstractMethod() {

        }
    };
}
