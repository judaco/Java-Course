package com.company;

/**
 * Created by Juda on 15/08/2016.
 */
public class MyClass {

    int x;

    public static class MyStaticNestedClass {//static nested class

        public void foo() {
            //System.out.println(x); - doesn't work!
        }
    }

    public class MyInnerClass {//inner class

        public void foo() {
            System.out.println(x);//there's an access, because it's a specific class
        }
    }

    public Object foo() {//local inner class
        class LocalInnerClass {
            public int x;

            public void goo() {
            }

            @Override//override of the class, and then I have a full access to the object
            public String toString() {
                return "hey, here it is. " + x;
            }
        }
        int x = 8;
        LocalInnerClass localInnerClass = new LocalInnerClass();
        localInnerClass.goo();
        localInnerClass.x = 19;
        return localInnerClass;
    }

    public Animal koo() {
        class Dog extends Animal {
            @Override
            public void makedSound() {//drisa shel makedSound from Animal
                System.out.println("dog is making sound");
            }

            public void bark() {

            }
        }
        Dog d = new Dog();
        return d;
    }

    public Animal joo(){//Anonymous class
        return new Animal(){
            @Override
            public void makedSound() {
                System.out.println("anonymous");
            }
        };
    }
}
