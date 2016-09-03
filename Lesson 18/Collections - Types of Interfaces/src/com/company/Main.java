package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

//  Types of Interfaces - Non Implementing
//  Iterable - When class implements the Iterable, she'll use a For Each Loop - passing by all the variables
//  Collection - There's no meaning for the order - using the methods min() and max()
//  List - There's a meaning for the order - using what I defined - like Lisatble
//  Set - A unique - his elements not reorder themselves - we are using 'equals' and 'hashcode'
//  Sorted Set - The element are ordered already / Navigable Set - like in the Index of function
//  Queue - like in queue the last who got in the last who came out / Deque - like magazine - the last who got in the first to came out - like 'addAt' function
//  Map - like ;Set;, but couples - Key and Value - has SortedMap and Navigable Map -  ex: Key - username, value - Password, the user name is unique only 1, the passowrd could be the same for
//  entire users.

        List<String > myString = new ArrayList<>();
        myString.add("Hugo");
        myString.add("Marcel");
        myString.add("Tiago");
        myString.add("Romeo");
        myString.add("Julia");
        for (String s : myString) {
            //System.out.println(s);
        }
        List<String> myString2 = new LinkedList<>();

        Set<String> myString3 = new HashSet<>();
        myString3.add("Cristiano");
        System.out.println(myString3.contains("Cristiano"));
        myString3.add("Cristiano");
        myString3.add("Benjamin");
        for (String s : myString3) {
            System.out.println(s);
        }

        Set<String > myString4 = new TreeSet<>();

        Map<String, String> users = new HashMap<>();
        users.put("Juda", "juda10");//I cannot add, I am determining (putting)
        users.put("Juda", "juda11");//changed the password(value) after recognized the same Key with new "value"
        System.out.println(users.get("Juda").equals("juda11"));//true

        Queue<String> e = new PriorityQueue<>();
        e.add("Gelato");
        e.add("Torta");
        String norittura;
        while ((norittura = e.poll()) != null){//I am checking if I can continue to next
            System.out.println(norittura);
        }

        Queue<Message> q = new PriorityQueue<>();
        q.add(new Message("Ciao"));
        q.add(new Message("Arrivederci"));
        Message m;
        while ((m = q.poll()) != null){
            System.out.println(m.text);
        }
    }
}

class Message implements Comparable<Message>{
    String text;//the message which sent
    long timeStamp;//calculating Time in long - when the text has been sent

    public Message(String text){
        this.text = text;
        this.timeStamp = System.nanoTime();
    }

    @Override
    public int compareTo(Message o){
        long delta = o.timeStamp - this.timeStamp;
        System.out.println(delta);
        if (delta > 0)
            return -1;
        else if(delta < 0)
            return 1;
        else
            return 0;
        //return (int)(o.timeStamp - this.timeStamp);//casting to int, cause we have time by long
    }
}
