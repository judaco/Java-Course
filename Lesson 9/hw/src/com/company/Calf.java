package com.company;

/**
 * Created by Juda on 13/08/2016.
 */
public class Calf extends Cow {
    String name;

    @Override
    public void goingToSleep(){
        System.out.println("calf is going to sleep " + name);
    }
}
