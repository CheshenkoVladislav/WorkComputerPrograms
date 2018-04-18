package com.example.vladislav.vkclient.Data.NewsFeed;

import com.example.vladislav.vkclient.Data.ProfilesPack.Profiles;

import java.util.List;

public class NewsFeedResponse {
    private List<NewsFeedAllItems> items;

    private List<Profiles> profiles;

    private List<String> groups;

    public void setItems(List<NewsFeedAllItems> items){
        this.items = items;
    }
    public List<NewsFeedAllItems> getItems(){
        return this.items;
    }
    public void setProfiles(List<Profiles> profiles){
        this.profiles = profiles;
    }
    public List<Profiles> getProfiles(){
        return this.profiles;
    }
    public void setGroups(List<String> groups){
        this.groups = groups;
    }
    public List<String> getGroups(){
        return this.groups;
    }
}
