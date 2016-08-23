package com.company;

/**
 * Created by Juda on 23/08/2016.
 */
public class MyList2 implements  Listable {

    Link anchor;
    Link last;
    int pos;

    public MyList2(){
        anchor = new Link(10);
        last = anchor;
        pos = 0;
    }


    @Override
    public void add(int num) {
        /*
        Link last = anchor;
        while(last.next != null){
            last = last.next;
        }
        */
        last.next = new Link(num);
        last = last.next;
        pos++;
    }

    @Override
    public void remove(int index) {
        if(index < 0 || index >= pos)
            throw new IndexOutOfBoundsException();
        Link theOneBefore = anchor;
        for (int i = 0; i < index; i++) {
            theOneBefore = theOneBefore.next;
        }
        theOneBefore.next = theOneBefore.next.next;
        pos--;
    }

    @Override
    public void addAt(int index, int num) {

    }

    @Override
    public void set(int index, int num) {

    }

    @Override
    public int get(int index) {
        return 0;
    }

    @Override
    public int indexOf(int num) {
        return 0;
    }

    @Override
    public int[] toArray() {
        return new int[0];
    }

    @Override
    public int size() {
        return 0;
    }

    static class Link{
        int value;
        Link next;

        public Link(int value){
            this.value = value;
        }
    }


}
