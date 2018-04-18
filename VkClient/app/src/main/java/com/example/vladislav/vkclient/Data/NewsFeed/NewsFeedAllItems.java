package com.example.vladislav.vkclient.Data.NewsFeed;

public class NewsFeedAllItems {
    private String type;

    private int source_id;

    private int date;

    private NewsFeedPhoto photos;

    private int post_id;

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setSource_id(int source_id){
        this.source_id = source_id;
    }
    public int getSource_id(){
        return this.source_id;
    }
    public void setDate(int date){
        this.date = date;
    }
    public int getDate(){
        return this.date;
    }
    public void setPhotos(NewsFeedPhoto photos){
        this.photos = photos;
    }
    public NewsFeedPhoto getPhotos(){
        return this.photos;
    }
    public void setPost_id(int post_id){
        this.post_id = post_id;
    }
    public int getPost_id(){
        return this.post_id;
    }
}
