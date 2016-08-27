package com.company;

public class Main {

    public static void main(String[] args) {
        Kayak<Integer, Integer> kayak = new Kayak<>(5, 18);
        kayak.setFront(3);

        Kayak<String, String> kayak2 = new Kayak<>("hi", "bye");
    }
}

class Kayak<T, K>{
    private T front;
    private K rear;
    public Kayak(T front, K rear){
        this.front = front;
        this.rear = rear;
    }

    public T getFront() {
        return front;
    }

    public void setFront(T front) {
        this.front = front;
    }

    public K getRear() {
        return rear;
    }

    public void setRear(K rear) {
        this.rear = rear;
    }
}