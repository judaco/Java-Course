package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by eladlavi on 04/09/2016.
 */
public class Main {
    public static void main(String[] args){

        /*Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.setName("t1");
        t2.setName("t2");
        t1.setPriority(5);
        t1.start();
        t2.start();
        t1.interrupt();*/


        UseCounter c = new UseCounter();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        Thread t3 = new Thread(c);
        t1.start();
        t2.start();
        t3.start();

        Map<String, String> users = new HashMap<>();
        boolean success = false;
        synchronized (users) {
            if (!users.containsKey("Liran")) {
                users.put("Liran", "12345");
                success = true;
            }
        }
        if(success)
            System.out.println("success");

    }

    /*public void searchExample(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new Integer(i*3));
        }
        SearchThread.ItemFoundListener listener = new SearchThread.ItemFoundListener() {
            int positionByThread1 = -2;
            int positionByThread2 = -2;
            boolean proceed = true;
            @Override
            public void itemFound(int id, int position) {
                if(id == 1)
                    positionByThread1 = position;
                else //id == 2
                    positionByThread2 = position;
                if(position == -1){
                    if(positionByThread1 == positionByThread2)
                        System.out.println("not found");
                }else{
                    System.out.println("found at " + position);
                    proceed = false;
                }
            }
            @Override
            public boolean proceed() {
                return proceed;
            }
        };
        Integer item = 270;
        SearchThread<Integer> t1 = new SearchThread<>(list, item, 0,
                list.size()/2, listener, 1);
        SearchThread<Integer> t2 = new SearchThread<>(list, item,
                list.size()/2, list.size(), listener, 2);
        t1.start();
        t2.start();
    }*/
}
class Counter{
    public static long count = 0;
}
class UseCounter implements Runnable{

    void increment(){
        synchronized (this) {
            Counter.count++;
            System.out.print(Counter.count + " ");
        }
    }

    @Override
    public void run() {
        increment();
        increment();
        increment();
    }
}
