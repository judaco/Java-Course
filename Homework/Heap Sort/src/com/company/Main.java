package com.company;

import java.nio.ByteBuffer;

public class Main {

    public static void main(String[] args) {
        int[] arr = {34, 12, 45, 22, 63, 12, 2, 8};

        /*Heap heap = new Heap();
        for (int i = 0; i < arr.length; i++) {
            heap.insert(arr[i]);
        }*/

        byte[] buffer = new byte[4];
        ByteBuffer.wrap(buffer).putInt(12);
        ByteBuffer.wrap(buffer).getInt();

        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
    }

    static void sort(int[] arr){
        Heap heap = new Heap(arr);
        for (int i = 0; i < arr.length; i++) {
            int max = heap.extractMax();
            arr[arr.length-1-i] = max;
        }
    }


}

interface PriorityQueue{
    void insert(int x);
    int extractMax();
    int getMax();
}

class Heap implements PriorityQueue{
    private int[] arr;
    int size;
    public Heap(){
        arr = new int[100];
        size = 0;
    }

    public Heap(int[] arr){
        this.arr = arr;
        size = arr.length;
        for (int i = size/2; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    @Override
    public void insert(int x) {
        if(size == arr.length){
            return;
        }
        size++;
        int i = size - 1;
        arr[i] = x;

        bubbleUp(i);

    }

    private void increase(int i, int newValue){
        if(arr[i]>newValue || i >= size)
            return;//exception
        arr[i] = newValue;

        bubbleUp(i);

    }

    private void delete(int i){
        increase(i, Integer.MAX_VALUE);
        extractMax();
    }




    @Override
    public int extractMax() {
        if(size == 0)
            throw new IndexOutOfBoundsException();
        if(size == 1) {
            size--;
            return arr[0];
        }
        int max = arr[0];
        arr[0] = arr[size-1];
        size--;
        heapifyDown(0);
        return max;
    }

    @Override
    public int getMax() {
        if(size == 0)
            throw new IndexOutOfBoundsException();
        return arr[0];
    }

    int parent(int i){
        return (i-1)/2;
    }

    int left(int i){
        return 2*i + 1;
    }

    int right(int i){
        return 2*i + 2;
    }


    private void bubbleUp(int i){
        int p;
        while(i != 0 && arr[(p=parent(i))] < arr[i]){
            int temp = arr[i];
            arr[i] = arr[p];
            arr[p] = temp;
            i = p;
        }
    }

    private void heapifyDown(int i){
        int l = left(i);
        int r = right(i);
        int largest = i;
        if(l < size && arr[l] > arr[largest])
            largest = l;
        if(r < size && arr[r] > arr[largest])
            largest = r;
        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapifyDown(largest);
        }
    }
}
