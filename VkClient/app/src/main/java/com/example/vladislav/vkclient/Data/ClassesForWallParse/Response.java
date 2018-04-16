package com.example.vladislav.vkclient.Data.ClassesForWallParse;

import java.util.List;

public class Response {
    private int count;

    private List<Items> items;

    private List<Profiles> profiles;

    private List<Groups> groups;

    public void setCount(int count){
        this.count = count;
    }
    public int getCount(){
        return this.count;
    }
    public void setItems(List<Items> items){
        this.items = items;
    }
    public List<Items> getItems(){
        return this.items;
    }
    public void setProfiles(List<Profiles> profiles){
        this.profiles = profiles;
    }
    public List<Profiles> getProfiles(){
        return this.profiles;
    }
    public void setGroups(List<Groups> groups){
        this.groups = groups;
    }
    public List<Groups> getGroups(){
        return this.groups;
    }
}
