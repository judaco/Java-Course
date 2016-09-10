package com.company;

import java.util.List;

/**
 * Created by Juda on 04/09/2016.
 */
public class SearchThread<T> extends Thread {

    private List<T> list;
    private T item;
    private int from, to;
    private ItemFoundListener listener;
    private int id;

    public SearchThread(List<T> list, T item, int from, int to,
                        ItemFoundListener listener, int id) {
        this.list = list;
        this.item = item;
        this.from = from;
        this.to = to;
        this.listener = listener;
        this.id = id;
    }


    @Override
    public void run() {
        if(listener == null)
            return;
        for (int i = from; i < to; i++) {
            if(!listener.proceed())
                return;
            if(list.get(i).equals(item)){
                listener.itemFound(id, i);
                return;
            }
        }
        listener.itemFound(id, -1);
    }


    static interface ItemFoundListener{
        void itemFound(int id, int position);
        boolean proceed();
    }
}
