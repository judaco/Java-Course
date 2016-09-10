package com.company;

import java.util.List;

/**
 * Created by Juda on 10/09/2016.
 */
public class SearchThread<T> extends Thread {
    private List<T> list;//where the item is in the List
    private T item;
    private int from, to;
    private ItemFoundListener listener;//field listener
    private int id;

    public SearchThread(List<T> list, T item, int from, int to, ItemFoundListener listener, int id){
        this.list = list;
        this.item = item;
        this.from = from;
        this.to = to;
        this.listener = listener;
        this.id = id;
    }


    @Override
    public void run() {
        for (int i = from; i < to; i++) {
            if (listener == null)//protection
                return;
            if (!listener.proceed())//the question if to proceed or not
                return;
            if (list.get(i).equals(item)){
                listener.itemFound(id, i);
                return;
            }
            listener.itemFound(id, -1);
        }
    }

    static interface ItemFoundListener{//metavech
        void itemFound(int id, int position);//inform to listener who found (id) and where (position)
        boolean proceed();//I am asking the listener, if I didn't notice you, maybe somebody else noticed, so I continue searching
    }
}
