package com.company;

/**
 * Created by Juda on 23/08/2016.
 */
public class MyList1 implements Listable {

    private int[] nums;
    private int pos;


    public MyList1(){
        nums = new int[10];
        pos = 0;

    }

    @Override
    public void add(int num) {
        makeRoom();
        nums[pos++] = num;
    }

    private void makeRoom(){
        if(pos == nums.length){//out of space
            int[] temp = new int[nums.length * 2];
            for (int i = 0; i < nums.length; i++) {
                temp[i] = nums[i];
            }
            nums = temp;
        }
    }



    @Override
    public void remove(int index) {
        if(index < 0 || index >= pos)
            throw new IndexOutOfBoundsException("trying to remove at " + index);
        for (int i = index; i < nums.length - 1; i++) {
            nums[i] = nums[i+1];
        }
        pos--;
    }



    @Override
    public void addAt(int index, int num) {
        if(index < 0 || index >= pos)
<<<<<<< HEAD
            throw new IndexOutOfBoundsException();
        Link theOneBefore = anchor;
        for (int i = 0; i < index; i++) {
            theOneBefore = theOneBefore.next;
        }
        Link added = new Link(num);
        added.next = theOneBefore.next;
        theOneBefore.next = added;
=======
            throw new IndexOutOfBoundsException("trying to add at " + index);
        makeRoom();
        for (int i = pos; i > index ; i--) {
            nums[i] = nums[i-1];
        }
        nums[index] = num;
>>>>>>> origin/master
        pos++;
    }

    @Override
    public void set(int index, int num) {
        if(index < 0 || index >= pos)
<<<<<<< HEAD
            throw new IndexOutOfBoundsException();
        Link link = anchor;
        for (int i = 0; i <= index; i++) {
            link = link.next;
        }
        link.value = num;
=======
            throw new IndexOutOfBoundsException("trying to set at " + index);
        nums[index] = num;
>>>>>>> origin/master
    }

    @Override
    public int get(int index) {
        if(index < 0 || index >= pos)
<<<<<<< HEAD
            throw new IndexOutOfBoundsException();
        Link link = anchor;
        for (int i = 0; i <= index; i++) {
            link = link.next;
        }
        return link.value;
=======
            throw new IndexOutOfBoundsException("trying to get at " + index);
        return nums[index];
>>>>>>> origin/master
    }

    @Override
    public int indexOf(int num) {
<<<<<<< HEAD
        Link link = anchor;
        int counter = 0;
        while(link.next != null){
            link = link.next;
            if(link.value == num)
                return counter;
            counter++;
        }
        return -1;
        /*
         Link a = anchor.next;
        for (int i = 0; i < pos; i++) {
            if(a.value == num)
                return i;
            a = a.next;
        }
        return -1;
        */
=======
        for (int i = 0; i < pos; i++) {
            if(nums[i] == num)
                return i;
        }
        return -1;
>>>>>>> origin/master
    }

    @Override
    public int[] toArray() {
<<<<<<< HEAD
        int[] arr = new int[pos];
        Link link = anchor;
        for (int i = 0; i < pos; i++) {
            link = link.next;
            arr[i] = link.value;
        }
        return arr;
=======
        int[] temp = new int[pos];
        for (int i = 0; i < pos; i++) {
            temp[i] = nums[i];
        }
        return temp;
>>>>>>> origin/master
    }

    @Override
    public int size() {
        return pos;
<<<<<<< HEAD
    }

    static class Link{
        int value;
        Link next;

        public Link(int value){
            this.value = value;
        }
    }
    @Override
    public String toString() {
        if(pos == 0){
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        Link link = anchor;
        for (int i = 0; i < pos - 1; i++) {
            link = link.next;
            stringBuilder.append(link.value + ",");
        }
        stringBuilder.append(last.value);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
=======
    }
>>>>>>> origin/master

}
