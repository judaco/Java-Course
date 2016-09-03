package com.company;

public class Main {
    public static void main(String[] args){
        System.out.println("start");

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hi");
                int result = longRunningTask();
                System.out.println("end " + result);
            }
        });
        t.start();

        System.out.println("done");
    }

    public static int longRunningTask(){
        int x = 0;
        for (int i = 0; i < 2000000000; i++) {
            for (int j = 0; j < 5; j++) {
                if(i%2==0)
                    x++;
            }
        }
        return x;
    }

    public static class SearchRunnable implements Runnable{

        private int from, to;
        private String[] words;
        private String word;

        public SearchRunnable(int from, int to, String[] words, String word) {
            this.from = from;
            this.to = to;
            this.words = words;
            this.word = word;
        }

        @Override
        public void run() {
            for (int i = from; i < to; i++) {
                if(words[i].equals(word))
                    System.out.println(i);
            }
        }
    }

    public static void search(String[] words, String word){
        /*Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < words.length / 2; i++) {
                    if(words[i].equals(word))
                        System.out.println(i);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = words.length / 2; i < words.length; i++) {
                    if(words[i].equals(word))
                        System.out.println(i);
                }
            }
        });
        t1.start();
        t2.start();*/
//        Runnable r1 = new SearchRunnable(0, words.length/2, words, word);
//        Runnable r2 = new SearchRunnable(words.length/2, words.length, words, word);
//        Thread t1 = new Thread(r1);
//        Thread t2 = new Thread(r2);

        Thread t1 = new SearchThread(0, words.length/2, words, word);
        Thread t2 = new SearchThread(words.length/2, words.length, words, word);


        t1.start();
        t2.start();
    }
}
