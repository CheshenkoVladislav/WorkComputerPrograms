package com.example.vladislav.vkclient.Data;

import java.util.List;

public class PhotoResponse {
    private int count;

    private List<PhotoItems> items;

    private int more;

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
    public void setMore(int more){
        this.more = more;
    }
    public int getMore(){
        return this.more;
    }
}
