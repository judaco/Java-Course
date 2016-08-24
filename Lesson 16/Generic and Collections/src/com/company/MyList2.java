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
            throw new IndexOutOfBoundsException("trying to add at " + index);
        makeRoom();
        for (int i = pos; i > index ; i--) {
            nums[i] = nums[i-1];
        }
        nums[index] = num;
        pos++;
    }

    @Override
    public void set(int index, int num) {
        if(index < 0 || index >= pos)
            throw new IndexOutOfBoundsException("trying to set at " + index);
        nums[index] = num;
    }

    @Override
    public int get(int index) {
        if(index < 0 || index >= pos)
            throw new IndexOutOfBoundsException("trying to get at " + index);
        return nums[index];
    }

    @Override
    public int indexOf(int num) {
        for (int i = 0; i < pos; i++) {
            if(nums[i] == num)
                return i;
        }
        return -1;
    }

    @Override
    public int[] toArray() {
        int[] temp = new int[pos];
        for (int i = 0; i < pos; i++) {
            temp[i] = nums[i];
        }
        return temp;
    }

    @Override
    public int size() {
        return pos;
    }

}
