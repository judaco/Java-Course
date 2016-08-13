package com.company;

public class Main {

    public static void main(String[] args) {
        Animal[] farmAnimlas;
        farmAnimlas = new Animal[5];

        farmAnimlas[0] = new Cow();
        farmAnimlas[1] = new Rooster();
        farmAnimlas[2] = new Sheep();
        farmAnimlas[3] = new Duck();
        farmAnimlas[4] = new Calf();
        ((Calf) farmAnimlas[4]).name = "Igi";

        Calf igi = new Calf();
//        washAnimal(igi);

        for (Animal animal : farmAnimlas) {
            animal.makeSound();
        }


        Number[] nums = {
                new Integer(4),
                new Double(3.4),
                new Long(34L),
                new Float(234.3f),
                3,
                new RationalNumber(12, 6)
        };
        System.out.println(sum(nums));
    }
    public static double sum (Number[] nums) {
        double sum = 0.0;
        for (Number num : nums) {
            sum += num.doubleValue();
        }
        return sum;
    }
}


    /*public static void washAnimal(Calf igi) {
        System.out.println("animal washed");
    }*/

    class Animal {
        void makeSound() {
            System.out.println("some sound");
        }

        void washAnimal() {
            System.out.println("wash");
        }

        public void goingToSleep() {
            System.out.println("going to sleep");
        }
    }

    class Cow extends Animal {
        void moo() {
            System.out.println("Moooo...");
        }

        void makeSound() {
            moo();
        }

        @Override
        public void goingToSleep() {
            System.out.println("cow is going to sleep");
        }
    }

    class Rooster extends Animal {
        void crow() {
            System.out.println("Ku..Ku..Ri..Ku");
        }

        void makeSound() {
            crow();
        }
    }

    class Sheep extends Animal {
        void bleat() {
            System.out.println("Meee...Meee...");
        }

        void makeSound() {
            bleat();
        }
    }

    class Duck extends Animal {
        void quack() {
            System.out.println("Qua...Qua...");
        }

        void makeSound() {
            quack();
        }
    }