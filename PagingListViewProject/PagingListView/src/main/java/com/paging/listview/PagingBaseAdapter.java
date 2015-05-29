package com.paging.listview;

import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;


public abstract class PagingBaseAdapter<T> extends BaseAdapter {

    protected List<T> items;

    public PagingBaseAdapter() {
        this.items = new ArrayList<T>();
    }

    public PagingBaseAdapter(List<T> items) {
        this.items = items;
    }

    public void addMoreItems(List<T> newItems) {
        this.items.addAll(newItems);
        notifyDataSetChanged();
    }

    public void addMoreItems(int location, List<T> newItems) {
        this.items.addAll(location, newItems);
        notifyDataSetChanged();
    }

    public void removeAllItems() {
        this.items.clear();
        notifyDataSetChanged();
    }


}
