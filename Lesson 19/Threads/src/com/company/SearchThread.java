package com.company;

/**
 * Created by Juda on 03/09/2016.
 */
public class SearchThread extends Thread {

    private int from, to;
    private String[] words;
    private String word;

    public SearchThread(int from, int to, String[] words, String word) {
        this.from = from;
        this.to = to;
        this.words = words;
        this.word = word;
    }
    @Override
    public void run () {
        for (int i = from; i < to / 2; i++) {
            if (words[i].equals(word))
                System.out.println(i);
        }
    }
}
