package com.example.vladislav.vkclient.Data.Photo;

import java.util.List;

public class PhotoResponse {
    private int count;

    private List<PhotoItems> items;

    public void setCount(int count){
        this.count = count;
    }
    public int getCount(){
        return this.count;
    }
    public void setItems(List<PhotoItems> items){
        this.items = items;
    }
    public List<PhotoItems> getItems(){
        return this.items;
    }
}
