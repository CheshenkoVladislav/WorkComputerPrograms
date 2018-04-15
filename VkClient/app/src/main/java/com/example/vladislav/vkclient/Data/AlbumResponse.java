package com.example.vladislav.vkclient.Data;

import java.util.List;

public class AlbumResponse {
    private int count;

    private List<AlbumItems> items;

    public void setCount(int count){
        this.count = count;
    }
    public int getCount(){
        return this.count;
    }
    public void setItems(List<AlbumItems> items){
        this.items = items;
    }
    public List<AlbumItems> getItems(){
        return this.items;
    }
}
