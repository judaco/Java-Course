package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new Integer(i * 3));//We will create 2 Threads, and each one will have his own Listener, but we
            //will use for now the same Listener for the 2 Threads.
        }
        SearchThread.ItemFoundListener listener = new SearchThread.ItemFoundListener() {

            int positionByThread1 = -2;//Will not inform nothing, he is still searching
            int positionByThread2 = -2;
            boolean proceed = true;

            @Override
            public void itemFound(int id, int position) {

                if (id == 1)
                    positionByThread1 = position;
                else // id == 2
                    positionByThread2 = position;
                if (position == -1) {//I finished the searching and not found
                    if (positionByThread1 == positionByThread2) {//it means the Thread found fron 0 and go on, and it's over
                        System.out.println("not found");
                       /* } else if (positionByThread2 == -2) {//still search
                            //don't do anything
                        } else {
                            System.out.println("found at " + positionByThread2);
                        }*/
                    } else {
                        System.out.println("found at " + position);
                        proceed = false;
                    }
                }
            }

            @Override
            public boolean proceed() {
                return false;
            }

        };

        Integer item = 270;
        SearchThread<Integer> t1 = new SearchThread<>(list, item, 0, list.size()/2, listener, 1);
        SearchThread<Integer> t2 = new SearchThread<>(list, item, list.size()/2, list.size(), listener, 2);
        t1.start();
        t2.start();
    }
}
