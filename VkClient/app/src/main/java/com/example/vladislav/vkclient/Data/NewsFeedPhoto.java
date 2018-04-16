package com.example.vladislav.vkclient.Data;

import java.util.List;

public class NewsFeedPhoto {
    private int count;

    private List<NewsFeedAllItems> items;

    public void setCount(int count){
        this.count = count;
    }
    public int getCount(){
        return this.count;
    }
    public void setItems(List<NewsFeedAllItems> items){
        this.items = items;
    }
    public List<NewsFeedAllItems> getItems(){
        return this.items;
    }
}
