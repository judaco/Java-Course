package com.company;

/**
 * Created by Juda on 23/08/2016.
 */
public interface Listable {

    void add(int num);
    void remove(int index);
    void addAt(int index, int num);
    void set(int index, int num);
    int get(int index);

    //return -1 if num doesn't exist, otherwise returns the
    //first occurrence of num
    int indexOf(int num);
    int[] toArray();
    int size();


}
